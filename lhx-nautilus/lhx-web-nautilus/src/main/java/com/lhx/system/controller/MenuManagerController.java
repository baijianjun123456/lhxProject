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
import com.lhx.system.service.MenuManagerService;
import com.lhx.system.menu.model.Menu;
import com.lhx.system.menu.model.MenuQuery;
import com.lhx.utils.StringUtil;
import com.lhx.utils.UUIDUtil;
import com.lhx.common.BaseController;


/**
 * 菜单管理控制器
 * @author liangshu
 *
 */
@Controller
@RequestMapping("/system/menuManager")
public class MenuManagerController extends BaseController{
	
	@Autowired
	private MenuManagerService menuManagerService;
	
	@RequestMapping(value="/page/{page}.do")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response,@PathVariable("page") String page,Menu menu){
		Map<String,Object>  resultMap = new HashMap<String,Object>();
		super.setParameter(request, resultMap);
		
		if("main".equals(resultMap.get("isMain"))){
			Menu queryMenu = new Menu();
			//queryMenu.setPid("0");
			resultMap.put("menuList",menuManagerService.getList(queryMenu));

		}else if(StringUtil.isNotBlank(menu.getId_())){
			resultMap.put("result", menuManagerService.get(menu.getId_()));
		}
		return new ModelAndView("/system/menu/"+page,resultMap);
	}
	
	@RequestMapping(value="/ajaxlist.do")
	@ResponseBody
	public String ajaxlist(HttpServletRequest request,HttpServletResponse response,MenuQuery menuQuery){

		Map<String,Object>  resultMap = new HashMap<String,Object>();
		
		menuManagerService.getListPage(menuQuery);
		
		resultMap.put("result", menuQuery);
		Gson gson = new Gson();
		
		return gson.toJson(menuQuery);
	}
	
	@RequestMapping(value="/addMenu.do")
	@ResponseBody
	public Map<String,Object> addMenu(HttpServletRequest request,HttpServletResponse response,Menu menu){
		Map<String,Object>  resultMap = new HashMap<String,Object>();
		menu.setId_(UUIDUtil.getUUID());
		menuManagerService.addMenu(menu);
		resultMap.put("flag", "true");
		return resultMap;
	}
	
	@RequestMapping(value="/updateMenu.do")
	@ResponseBody
	public Map<String,Object> updateMenu(HttpServletRequest request,HttpServletResponse response,Menu menu){
		Map<String,Object>  resultMap = new HashMap<String,Object>();
		menuManagerService.updateMenu(menu);
		resultMap.put("flag", "true");
		return resultMap;
	}
	
	@RequestMapping(value="/deleteMenu.do")
	@ResponseBody
	public Map<String,Object> deleteUser(HttpServletRequest request,HttpServletResponse response,Menu menu){
		Map<String,Object>  resultMap = new HashMap<String,Object>();
		menuManagerService.removeMenu(menu,false );
		resultMap.put("flag", "true");
		return resultMap;
	}
	
	@RequestMapping(value="/queryMenu.do")
	public Menu queryUser(HttpServletRequest request,HttpServletResponse response,Menu menu){
		return menuManagerService.get(menu.getId_());
	}

}
