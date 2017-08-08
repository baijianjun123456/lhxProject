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
import com.lhx.system.service.FormDefManagerService;
import com.lhx.system.service.FormTypeManagerService;
import com.lhx.system.formDef.model.FormDef;
import com.lhx.system.formDef.model.FormDefQuery;
import com.lhx.system.formType.model.FormType;
import com.lhx.utils.UUIDUtil;


/**
 * 表单定义管理控制器
 * @author liangshu
 *
 */
@Controller
@RequestMapping("/system/formDefManager")
public class FormDefManagerController extends BaseController{
	
	@Autowired
	private FormDefManagerService formDefManagerService;
	
	@Autowired
	private FormTypeManagerService formTypeManagerService;
	
	@RequestMapping(value="/page/{page}.do")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response,@PathVariable("page") String page,FormDef formDef){
		Map<String,Object>  resultMap = new HashMap<String,Object>();
		super.setParameter(request, resultMap);
		if("main".equals(resultMap.get("isMain"))){
			FormType formType = new FormType();
			formType.setStatus("1");
			resultMap.put("formTypeList", formTypeManagerService.getList(formType));
		}
		if("modify".equals(resultMap.get("type"))){
			resultMap.put("result", formDefManagerService.get(formDef.getId_()));
		}
		return new ModelAndView("/system/formDef/"+page,resultMap);
	}
	
	@RequestMapping(value="/ajaxlist.do")
	@ResponseBody
	public String ajaxlist(HttpServletRequest request,HttpServletResponse response,FormDefQuery formDefQuery){

		Map<String,Object>  resultMap = new HashMap<String,Object>();
		
		formDefQuery.setOrderbyInfo("FORM_CODE DESC");
		formDefQuery.setStatus("1");
		
		formDefManagerService.getListPage(formDefQuery);
		
		resultMap.put("result", formDefQuery);
		Gson gson = new Gson();
		
		return gson.toJson(formDefQuery);
	}
	
	@RequestMapping(value="/addFormDef.do")
	@ResponseBody
	public Map<String,Object> addFormDef(HttpServletRequest request,HttpServletResponse response,FormDef formDef){
		Map<String,Object>  resultMap = new HashMap<String,Object>();
		formDef.setId_(UUIDUtil.getUUID());
		formDefManagerService.addFormDef(formDef);
		resultMap.put("flag", "true");
		return resultMap;
	}
	
	@RequestMapping(value="/updateFormDef.do")
	@ResponseBody
	public Map<String,Object> updateFormDef(HttpServletRequest request,HttpServletResponse response,FormDef formDef){
		Map<String,Object>  resultMap = new HashMap<String,Object>();
		formDefManagerService.updateFormDef(formDef);
		resultMap.put("flag", "true");
		return resultMap;
	}
	
	@RequestMapping(value="/deleteFormDef.do")
	@ResponseBody
	public Map<String,Object> deleteUser(HttpServletRequest request,HttpServletResponse response,FormDef formDef){
		Map<String,Object>  resultMap = new HashMap<String,Object>();
		formDefManagerService.removeFormDef(formDef,false );
		resultMap.put("flag", "true");
		return resultMap;
	}
	
	@RequestMapping(value="/queryFormDef.do")
	public FormDef queryUser(HttpServletRequest request,HttpServletResponse response,FormDef formDef){
		return formDefManagerService.get(formDef.getId_());
	}
	

}
