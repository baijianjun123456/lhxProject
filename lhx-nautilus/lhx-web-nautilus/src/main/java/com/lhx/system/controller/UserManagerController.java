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
import com.lhx.common.BaseController;
import com.lhx.system.service.RoleManagerService;
import com.lhx.system.service.impl.UserManagerServiceImpl;
import com.lhx.system.user.model.User;
import com.lhx.system.user.model.UserQuery;
import com.lhx.system.userRole.model.UserRole;
import com.lhx.utils.EncryptUtil;
import com.lhx.utils.JsonUtil;
import com.lhx.utils.StringUtil;
import com.lhx.utils.UUIDUtil;


/**
 * 用户管理控制器
 * @author liangshu
 *
 */
@Controller
@RequestMapping("/system/userManager")
public class UserManagerController extends BaseController{
	
	@Autowired
	private UserManagerServiceImpl userManagerServiceImpl;
	
	@Autowired
	private RoleManagerService roleManagerService;
	
	@RequestMapping(value="/page/{page}.do")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response,@PathVariable("page") String page,User user){
		Map<String,Object>  resultMap = new HashMap<String,Object>();
		super.setParameter(request, resultMap);
		if(StringUtil.isNotBlank(user.getId_())){
			resultMap.put("result", userManagerServiceImpl.get(user));
		}
		return new ModelAndView("/system/user/"+page,resultMap);
	}
	
	@RequestMapping(value="/page/userAddRole.do")
	public ModelAndView userAddRole(HttpServletRequest request,HttpServletResponse response,String page,String  userId){
		Map<String,Object>  resultMap = new HashMap<String,Object>();
		super.setParameter(request, resultMap);
		if(StringUtil.isNotBlank(userId)){
			resultMap.putAll(roleManagerService.getNotOrSelectRole(userId, ""));
		}
		return new ModelAndView("/system/user/userAddRole",resultMap);
	}
	
	@RequestMapping(value="/saveUserRoles.do")
	@ResponseBody
	public ModelAndView saveUserRoles(HttpServletRequest request,HttpServletResponse response,String userRoleStr){
		Map<String,Object>  resultMap = new HashMap<String,Object>();
		List<UserRole> userRoles = JsonUtil.strToObj(userRoleStr, new TypeToken<List<UserRole>>(){}.getType());
		for(UserRole userRole : userRoles){
			userRole.setId_(UUIDUtil.getUUID());
			userRole.setStatus("1");
		}
		roleManagerService.saveUserRoles(userRoles);
		return new ModelAndView("/system/user/userAddRole",resultMap);
	}
	
	@RequestMapping(value="/ajaxlist.do")
	@ResponseBody
	public String ajaxlist(HttpServletRequest request,HttpServletResponse response,UserQuery userQuery){

		Map<String,Object>  resultMap = new HashMap<String,Object>();
		
		userManagerServiceImpl.getListPage(userQuery);
		
		resultMap.put("result", userQuery);
		Gson gson = new Gson();
		
		return gson.toJson(userQuery);
	}
	
	@RequestMapping(value="/checkIsExist.do")
	@ResponseBody
	public Map<String,Object> checkIsExist(HttpServletRequest request,HttpServletResponse response,User user,String type){
		Map<String,Object>  resultMap = new HashMap<String,Object>();

		String isExist = "false";
		user = userManagerServiceImpl.get(user);
		if(user != null){
			isExist = "true";
			resultMap.put("id_", user.getId_());
		}
		resultMap.put(type, type);
		resultMap.put("flag", isExist);
		return resultMap;
	}
	
	@RequestMapping(value="/addUser.do")
	@ResponseBody
	public Map<String,Object> addUser(HttpServletRequest request,HttpServletResponse response,User user){
		Map<String,Object>  resultMap = new HashMap<String,Object>();
		user.setPassword(EncryptUtil.md5encrypt(user.getPassword()));
		user.setId_(UUIDUtil.getUUID());
		userManagerServiceImpl.addUser(user);
		resultMap.put("flag", "true");
		return resultMap;
	}
	
	@RequestMapping(value="/updateUser.do")
	@ResponseBody
	public Map<String,Object> updateUser(HttpServletRequest request,HttpServletResponse response,User user){
		Map<String,Object>  resultMap = new HashMap<String,Object>();
		userManagerServiceImpl.updateUser(user);
		resultMap.put("flag", "true");
		return resultMap;
	}
	
	@RequestMapping(value="/deleteUser.do")
	@ResponseBody
	public Map<String,Object> deleteUser(HttpServletRequest request,HttpServletResponse response,User user){
		Map<String,Object>  resultMap = new HashMap<String,Object>();
		userManagerServiceImpl.removeUser(user,false );
		resultMap.put("flag", "true");
		return resultMap;
	}
	
	@RequestMapping(value="/queryUser.do")
	public User queryUser(HttpServletRequest request,HttpServletResponse response,User user){
		return userManagerServiceImpl.get(user);
	}

}
