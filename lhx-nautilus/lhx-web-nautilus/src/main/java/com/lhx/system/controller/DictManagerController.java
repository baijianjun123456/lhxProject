package com.lhx.system.controller;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.google.gson.Gson;
import com.lhx.system.service.DictManagerService;
import com.lhx.system.dict.model.Dict;
import com.lhx.system.dict.model.DictQuery;
import com.lhx.utils.UUIDUtil;
import com.lhx.common.BaseController;


/**
 * 数据字典管理控制器
 * @author liangshu
 *
 */
@Controller
@RequestMapping("/system/dictManager")
public class DictManagerController extends BaseController{
	
	@Autowired
	private DictManagerService dictManagerService;
	
	@RequestMapping(value="/page/{page}.do")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response,@PathVariable("page") String page,Dict dict){
		Map<String,Object>  resultMap = new HashMap<String,Object>();
		super.setParameter(request, resultMap);
		if("modify".equals(resultMap.get("type"))){
			resultMap.put("result", dictManagerService.get(dict.getId_()));
		}
		return new ModelAndView("/system/dict/"+page,resultMap);
	}
	
	@RequestMapping(value="/ajaxlist.do")
	@ResponseBody
	public String ajaxlist(HttpServletRequest request,HttpServletResponse response,DictQuery dictQuery){

		Map<String,Object>  resultMap = new HashMap<String,Object>();
		
		dictManagerService.getListPage(dictQuery);
		
		resultMap.put("result", dictQuery);
		Gson gson = new Gson();
		
		return gson.toJson(dictQuery);
	}
	
	@RequestMapping(value="/addDict.do")
	@ResponseBody
	public Map<String,Object> addDict(HttpServletRequest request,HttpServletResponse response,Dict dict){
		Map<String,Object>  resultMap = new HashMap<String,Object>();
		dict.setId_(UUIDUtil.getUUID());
		dict.setI18n(Locale.getDefault().toString());
		dict.setStatus("1");
		dictManagerService.addDict(dict);
		resultMap.put("flag", "true");
		return resultMap;
	}
	
	@RequestMapping(value="/updateDict.do")
	@ResponseBody
	public Map<String,Object> updateDict(HttpServletRequest request,HttpServletResponse response,Dict dict){
		Map<String,Object>  resultMap = new HashMap<String,Object>();
		dict.setI18n(Locale.getDefault().toString());
		dictManagerService.updateDict(dict);
		resultMap.put("flag", "true");
		return resultMap;
	}
	
	@RequestMapping(value="/deleteDict.do")
	@ResponseBody
	public Map<String,Object> deleteUser(HttpServletRequest request,HttpServletResponse response,Dict dict){
		Map<String,Object>  resultMap = new HashMap<String,Object>();
		dictManagerService.removeDict(dict,false );
		resultMap.put("flag", "true");
		return resultMap;
	}
	
	@RequestMapping(value="/queryDict.do")
	public Dict queryUser(HttpServletRequest request,HttpServletResponse response,Dict dict){
		return dictManagerService.get(dict.getId_());
	}

}
