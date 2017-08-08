package com.lhx.common;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.google.gson.Gson;
import com.lhx.common.service.tree.TreeService;
import com.lhx.utils.SpringConfigTool;

/**
 * 业务树控制器
 * @author liangshu
 *
 */
@Controller
@RequestMapping("/system/treeManager")
public class TreeController extends BaseController {
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/ajaxJson.do")
	@ResponseBody
	public String ajaxJson(HttpServletRequest request,HttpServletResponse response){

		Map<String,Object>  resultMap = new HashMap<String,Object>();
		
		super.setParameter(request, resultMap);
		
		TreeService treeService = (TreeService)SpringConfigTool.getBean((String)resultMap.get("serviceName"));
				
		Gson gson = new Gson();
		
		return gson.toJson(treeService.createTree(resultMap));
	}

}
