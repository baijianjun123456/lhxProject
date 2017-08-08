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
import com.lhx.file.model.TabColModel;
import com.lhx.system.service.FormDefManagerService;
import com.lhx.system.service.FormTypeManagerService;
import com.lhx.system.service.impl.FormManagerServiceImpl;
import com.lhx.system.form.model.Form;
import com.lhx.system.form.model.FormQuery;
import com.lhx.system.formType.model.FormType;
import com.lhx.utils.UUIDUtil;


/**
 * 表单管理管理控制器
 * @author liangshu
 *
 */
@Controller
@RequestMapping("/system/formManager")
public class FormManagerController extends BaseController{
	
	@Autowired
	private FormManagerServiceImpl formManagerServiceImpl;
	
	@Autowired
	private FormTypeManagerService formTypeManagerService;
	
	@Autowired
	private FormDefManagerService formDefManagerService;
	
	@RequestMapping(value="/page/{page}.do")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response,@PathVariable("page") String page,Form form){
		Map<String,Object>  resultMap = new HashMap<String,Object>();
		super.setParameter(request, resultMap);
		if("main".equals(resultMap.get("isMain"))){
			FormType formType_= new FormType();
			formType_.setStatus("1");
			resultMap.put("formTypeList", formTypeManagerService.getList(formType_));
		}
		
		if("addForm".equals(page) || "formList".equals(page)){
			resultMap.put("tableList", formManagerServiceImpl.getTableList());
		}
		return new ModelAndView("/system/form/"+page,resultMap);
	}
	
	@RequestMapping(value="/ajaxlist.do")
	@ResponseBody
	public String ajaxlist(HttpServletRequest request,HttpServletResponse response,FormQuery formQuery){

		Map<String,Object>  resultMap = new HashMap<String,Object>();
		
		formManagerServiceImpl.getListPage(formQuery);
		
		resultMap.put("result", formQuery);
		Gson gson = new Gson();
		
		return gson.toJson(formQuery);
	}
	
	@RequestMapping(value="/initFormFiled.do")
	@ResponseBody
	public void initFormFiled(HttpServletRequest request,HttpServletResponse response,TabColModel  tabColModel){
		
		formManagerServiceImpl.initFormFiled(tabColModel);
		
	}
	
	@RequestMapping(value="/addForm.do")
	@ResponseBody
	public Map<String,Object> addForm(HttpServletRequest request,HttpServletResponse response,Form form){
		Map<String,Object>  resultMap = new HashMap<String,Object>();
		form.setId_(UUIDUtil.getUUID());
		formManagerServiceImpl.addForm(form);
		resultMap.put("flag", "true");
		return resultMap;
	}
	
	@RequestMapping(value="/updateForm.do")
	@ResponseBody
	public Map<String,Object> updateForm(HttpServletRequest request,HttpServletResponse response,Form form){
		Map<String,Object>  resultMap = new HashMap<String,Object>();
		formManagerServiceImpl.updateForm(form);
		resultMap.put("flag", "true");
		return resultMap;
	}
	
	@RequestMapping(value="/deleteForm.do")
	@ResponseBody
	public Map<String,Object> deleteUser(HttpServletRequest request,HttpServletResponse response,Form form){
		Map<String,Object>  resultMap = new HashMap<String,Object>();
		formManagerServiceImpl.removeForm(form,false );
		resultMap.put("flag", "true");
		return resultMap;
	}
	
	@RequestMapping(value="/queryForm.do")
	public Form queryUser(HttpServletRequest request,HttpServletResponse response,Form form){
		return formManagerServiceImpl.get(form);
	}

}
