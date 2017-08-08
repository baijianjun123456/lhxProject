package com.lhx.system.controller;

import java.util.HashMap;
import java.util.List;
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
import com.google.gson.reflect.TypeToken;
import com.lhx.system.service.RoleManagerService;
import com.lhx.system.role.model.Role;
import com.lhx.system.role.model.RoleQuery;
import com.lhx.system.roleMenu.model.RoleMenu;
import com.lhx.utils.JsonUtil;
import com.lhx.utils.StringUtil;
import com.lhx.utils.UUIDUtil;
import com.lhx.common.BaseController;


/**
 * 角色管理管理控制器
 * @author liangshu
 *
 */
@Controller
@RequestMapping("/system/roleManager")
public class RoleManagerController extends BaseController{
	
	@Autowired
	private RoleManagerService roleManagerService;
	
	@RequestMapping(value="/page/{page}.do")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response,@PathVariable("page") String page,Role role){
		Map<String,Object>  resultMap = new HashMap<String,Object>();
		super.setParameter(request, resultMap);
		if(StringUtil.isNotBlank(role.getId_())){
			resultMap.put("result", roleManagerService.get(role.getId_()));
		}
		return new ModelAndView("/system/role/"+page,resultMap);
	}
	
	@RequestMapping(value="/ajaxlist.do")
	@ResponseBody
	public String ajaxlist(HttpServletRequest request,HttpServletResponse response,RoleQuery roleQuery){

		Map<String,Object>  resultMap = new HashMap<String,Object>();
		
		roleManagerService.getListPage(roleQuery);
		
		resultMap.put("result", roleQuery);
		Gson gson = new Gson();
		
		return gson.toJson(roleQuery);
	}
	
	@RequestMapping(value="/addRole.do")
	@ResponseBody
	public Map<String,Object> addRole(HttpServletRequest request,HttpServletResponse response,Role role){
		Map<String,Object>  resultMap = new HashMap<String,Object>();
		role.setId_(UUIDUtil.getUUID());
		roleManagerService.addRole(role);
		resultMap.put("flag", "true");
		return resultMap;
	}
	
	@RequestMapping(value="/updateRole.do")
	@ResponseBody
	public Map<String,Object> updateRole(HttpServletRequest request,HttpServletResponse response,Role role){
		Map<String,Object>  resultMap = new HashMap<String,Object>();
		roleManagerService.updateRole(role);
		resultMap.put("flag", "true");
		return resultMap;
	}
	
	@RequestMapping(value="/deleteRole.do")
	@ResponseBody
	public Map<String,Object> deleteUser(HttpServletRequest request,HttpServletResponse response,Role role){
		Map<String,Object>  resultMap = new HashMap<String,Object>();
		roleManagerService.removeRole(role,false );
		resultMap.put("flag", "true");
		return resultMap;
	}
	
	@RequestMapping(value="/queryRole.do")
	public Role queryUser(HttpServletRequest request,HttpServletResponse response,Role role){
		return roleManagerService.get(role.getId_());
	}
	
	@RequestMapping(value="/saveRoleAddMenu.do")
	@ResponseBody
	public Map<String,Object> saveRoleAddMenu(HttpServletRequest request,HttpServletResponse response,String roleMenuStr){
		Map<String,Object>  resultMap = new HashMap<String,Object>();
		List<RoleMenu> roleMenus = JsonUtil.strToObj(roleMenuStr, new TypeToken<List<RoleMenu>>(){}.getType());
		for(RoleMenu roleMenu : roleMenus){
			roleMenu.setId_(UUIDUtil.getUUID());
			roleMenu.setStatus("1");
		}
		roleManagerService.saveRoleMenuList(roleMenus);
		resultMap.put("flag", "true");
		return resultMap;
	}
}
