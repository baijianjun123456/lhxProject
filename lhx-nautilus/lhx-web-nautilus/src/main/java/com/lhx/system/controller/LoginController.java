package com.lhx.system.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lhx.Message.service.PublicizeManagerService;
import com.lhx.common.constants.RoleCodeConstants;
import com.lhx.common.utils.SessionUtil;
import com.lhx.message.publicize.model.Publicize;
import com.lhx.message.publicize.model.PublicizeQuery;

/**
 * 登陆控制器。
 * @author liangshu
 *
 */
@Controller
@RequestMapping("/system/login")
public class LoginController {
	@Autowired
	private PublicizeManagerService publicizeManagerService;
	
	@RequestMapping(value="/login.do")
	public ModelAndView login(HttpServletRequest request){
		
		Map<String,String>  resultMap = new HashMap<String,String>();
		return new ModelAndView("/system/login/login",resultMap);
	}
	
	
	@RequestMapping(value="/welcome.do")
	public ModelAndView welcome(HttpServletRequest request){
		Map<String,Object>  resultMap = new HashMap<String,Object>();
		
		//管理员角色登录；
		if(SessionUtil.isHaveRole(request, RoleCodeConstants.R_SYSTEM)){
			return new ModelAndView("/system/login/welcome2",resultMap);

		}
		else{
			PublicizeQuery pubQuery=new PublicizeQuery();
			List<Publicize> pubList=publicizeManagerService.getListPage(pubQuery);
			resultMap.put("resultList", pubList);		
			return new ModelAndView("/system/login/welcome",resultMap);

		}
	}
	
	
}
