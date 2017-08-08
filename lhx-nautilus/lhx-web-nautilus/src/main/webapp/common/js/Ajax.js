
var ajax = {};
var request = {};

/**
 * 发送ajax请求;
 * @param type : 请求类型;
 * @param url : 请求地址;
 * @param errorThrown : 请求;参数
 * @param successFun : 请求成功回调函数;
 * @param errFun : 请求失败回调函数;
 * @return
 */
ajax.sendRequest=function(type,url,data,_successFun,_errFun,async)
{	
	
	
	successFun = function(returnData){

		//弹出系统一次信息;
		if(_successFun){
			_successFun(returnData);
		}	

	};
	
	errFun = function(XMLHttpRequest, textStatus, errorThrown){
		
		if(_errFun){
			_errFun(XMLHttpRequest, textStatus, errorThrown);
		}
		
	};
	
	 $.ajax({
		   type: "POST",
		   url: url,
		   data: data,
		   success: successFun,
		   error:errFun,
		   async:async
		});

};


/**
 * 发送ajax请求;
 * @param type : 请求类型;
 * @param url : 请求地址;
 * @param errorThrown : 请求;参数
 * @param successFun : 请求成功回调函数;
 * @param errFun : 请求失败回调函数;
 * @return
 */
ajax.sendJsonRequest=function(type,url,data,_successFun,_errFun,async)
{
	successFun = function(returnData){
			if(_successFun){
				_successFun(returnData);
			}
	};
	
	errFun = function(XMLHttpRequest, textStatus, errorThrown){
		if(_errFun){
			_errFun(XMLHttpRequest, textStatus, errorThrown);
		}
	};
	
	$.ajax({
		   type: type,
		   datatype: "json",
		   url: url,
		   data: data,
		   success: successFun,
		   error:errFun,
		   async:async
		}) ;

};