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
import com.lhx.system.service.ResourceManagerService;
import com.lhx.system.resource.model.Resource;
import com.lhx.system.resource.model.ResourceQuery;
import com.lhx.utils.StringUtil;
import com.lhx.utils.UUIDUtil;
import com.lhx.common.BaseController;


/**
 * 系统资源访问表管理控制器
 * @author liangshu
 *
 */
@Controller
@RequestMapping("/system/resourceManager")
public class ResourceManagerController extends BaseController{
	
	@Autowired
	private ResourceManagerService resourceManagerService;
	
	@RequestMapping(value="/page/{page}.do")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response,@PathVariable("page") String page,Resource resource){
		Map<String,Object>  resultMap = new HashMap<String,Object>();
		super.setParameter(request, resultMap);
		if(StringUtil.isNotBlank(resource.getId_())){
			resultMap.put("result", resourceManagerService.get(resource.getId_()));
		}
		return new ModelAndView("/system/resource/"+page,resultMap);
	}
	
	@RequestMapping(value="/ajaxlist.do")
	@ResponseBody
	public String ajaxlist(HttpServletRequest request,HttpServletResponse response,ResourceQuery resourceQuery){

		Map<String,Object>  resultMap = new HashMap<String,Object>();
		
		resourceManagerService.getListPage(resourceQuery);
		
		resultMap.put("result", resourceQuery);
		Gson gson = new Gson();
		
		return gson.toJson(resourceQuery);
	}
	
	@RequestMapping(value="/addResource.do")
	@ResponseBody
	public Map<String,Object> addResource(HttpServletRequest request,HttpServletResponse response,Resource resource){
		Map<String,Object>  resultMap = new HashMap<String,Object>();
		resource.setId_(UUIDUtil.getUUID());
		resourceManagerService.addResource(resource);
		resultMap.put("flag", "true");
		return resultMap;
	}
	
	@RequestMapping(value="/updateResource.do")
	@ResponseBody
	public Map<String,Object> updateResource(HttpServletRequest request,HttpServletResponse response,Resource resource){
		Map<String,Object>  resultMap = new HashMap<String,Object>();
		resourceManagerService.updateResource(resource);
		resultMap.put("flag", "true");
		return resultMap;
	}
	
	@RequestMapping(value="/deleteResource.do")
	@ResponseBody
	public Map<String,Object> deleteUser(HttpServletRequest request,HttpServletResponse response,Resource resource){
		Map<String,Object>  resultMap = new HashMap<String,Object>();
		resourceManagerService.removeResource(resource,false );
		resultMap.put("flag", "true");
		return resultMap;
	}
	
	@RequestMapping(value="/queryResource.do")
	public Resource queryUser(HttpServletRequest request,HttpServletResponse response,Resource resource){
		return resourceManagerService.get(resource.getId_());
	}

}
