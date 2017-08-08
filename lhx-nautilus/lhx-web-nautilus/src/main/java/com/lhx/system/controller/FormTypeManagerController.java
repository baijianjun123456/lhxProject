package com.lhx.system.controller;

import java.util.HashMap;
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
import com.lhx.common.BaseController;
import com.lhx.system.service.FormTypeManagerService;
import com.lhx.system.formType.model.FormType;
import com.lhx.system.formType.model.FormTypeQuery;
import com.lhx.utils.StringUtil;
import com.lhx.utils.UUIDUtil;


/**
 * 表单分类管理控制器
 * @author liangshu
 *
 */
@Controller
@RequestMapping("/system/formTypeManager")
public class FormTypeManagerController  extends BaseController{
	
	@Autowired
	private FormTypeManagerService formTypeManagerService;
	
	@RequestMapping(value="/page/{page}.do")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response,@PathVariable("page") String page,FormType formType){
		Map<String,Object>  resultMap = new HashMap<String,Object>();
		super.setParameter(request, resultMap);
		if(StringUtil.isNotBlank(formType.getId_())){
			resultMap.put("result", formTypeManagerService.get(formType.getId_()));
		}
		return new ModelAndView("/system/formType/"+page,resultMap);
	}
	
	@RequestMapping(value="/ajaxlist.do")
	@ResponseBody
	public String ajaxlist(HttpServletRequest request,HttpServletResponse response,FormTypeQuery formTypeQuery){

		Map<String,Object>  resultMap = new HashMap<String,Object>();
		
		formTypeQuery.setOrderbyInfo("CODE DESC");
		formTypeQuery.setStatus("1");
		formTypeManagerService.getListPage(formTypeQuery);
		
		resultMap.put("result", formTypeQuery);
		Gson gson = new Gson();
		
		return gson.toJson(formTypeQuery);
	}
	
	@RequestMapping(value="/addFormType.do")
	@ResponseBody
	public Map<String,Object> addFormType(HttpServletRequest request,HttpServletResponse response,FormType formType){
		Map<String,Object>  resultMap = new HashMap<String,Object>();
		formType.setId_(UUIDUtil.getUUID());
		formTypeManagerService.addFormType(formType);
		resultMap.put("flag", "true");
		return resultMap;
	}
	
	@RequestMapping(value="/updateFormType.do")
	@ResponseBody
	public Map<String,Object> updateFormType(HttpServletRequest request,HttpServletResponse response,FormType formType){
		Map<String,Object>  resultMap = new HashMap<String,Object>();
		formTypeManagerService.updateFormType(formType);
		resultMap.put("flag", "true");
		return resultMap;
	}
	
	@RequestMapping(value="/deleteFormType.do")
	@ResponseBody
	public Map<String,Object> deleteUser(HttpServletRequest request,HttpServletResponse response,FormType formType){
		Map<String,Object>  resultMap = new HashMap<String,Object>();
		formTypeManagerService.removeFormType(formType,false );
		resultMap.put("flag", "true");
		return resultMap;
	}
	
	@RequestMapping(value="/queryFormType.do")
	public FormType queryUser(HttpServletRequest request,HttpServletResponse response,FormType formType){
		return formTypeManagerService.get(formType.getId_());
	}

}
