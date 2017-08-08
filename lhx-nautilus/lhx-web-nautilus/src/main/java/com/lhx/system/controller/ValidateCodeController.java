package com.lhx.system.controller;

import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.lhx.common.utils.SessionUtil;
import com.lhx.system.service.constants.SystemConstants;
import com.lhx.utils.ValidateCode;

/**
 * 登陆控制�?
 * @author liangshu
 *
 */
@Controller
@RequestMapping("/system/validateCode")
public class ValidateCodeController {
	
	@RequestMapping(value="/png.do")
	public void login(HttpServletRequest request,HttpServletResponse response){
		
		ValidateCode vCode = new ValidateCode(100,28,4,50); 
		
		SessionUtil.addAttr(request, SystemConstants.Session.LOGIN_CODE, vCode.getCode());

		response.setContentType("image/png");
		
		OutputStream os = null;

		try {
			
			os = response.getOutputStream();

			ImageIO.write(vCode.getBuffImg(), "png", os);
			
			os.flush();   
			
	        os.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{

		}
		

	}

}
