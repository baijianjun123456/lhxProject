$(function(){
	$("#loginsubmit").click(function(){ajaxLogin("loginForm");});
	
	$("#codeImg").click(function(){reloadImg();});
	
	reloadImg();
});



function ajaxLogin(formId){
	
	function success(data){
		reloadImg();
		if(data.resCd != "00"){
			message.error("错误",data.resMsg);
		}
		else{
			window.location.href=basePath+data.resUrl;			
		}
	}
	
	function error(){
		reloadImg();
		message.error("错误","系统错误！");
	}
	ajax.sendJsonRequest("POST",basePath+"ajaxlogin",$("#"+formId).serialize(),success,error);
}

function reloadImg(){
		
	$("#codeImg").attr("src",basePath+"system/validateCode/png.do?t="+Math.random());
}