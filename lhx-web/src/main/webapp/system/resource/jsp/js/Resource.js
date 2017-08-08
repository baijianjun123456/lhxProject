var columns  = [[
		           //{field:'name',title:'用户名',width:100,hidden:false},
		           {field:'name',title:'用户名',width:300},
		           {field:'accounts',title:'账号',width:300},
		           {field:'email',title:'邮箱',width:300},
		           {field:'mobile',title:'手机',width:250},
		           {field:'status',title:'状态',width:150}
               ]];

var tilte = "系统资源访问表列表";

var page = null;
$(function(){
	
	page = new Page("resourceList","系统资源访问表列表",columns,'add,remove,modify',basePath+"system/resourceManager/ajaxlist.do","resourceSearchForm");
	
	$("#submitid").click(function(){page.doSearch();});
	
	$("#saveResource").click(function(){saveresource();});
	
	$("#clearResource").click(function(){$("#addResourceForm").form('clear');});
});

/**
 * 创建新增系统资源访问表页签
 */
function addData(){
	function callback(){
		page.doSearch();
	}
	
	window.parent.addTab("添加@moduleNameCH","添加@moduleNameCH",basePath+"system/resourceManager/page/addResource.do?type=add",callback,true);
}

/**
 *创建更新系统资源访问表页签
 */
function modifyData(){
	function callback(){
		page.doSearch();
	}
	var id_ = page.getSelectRows(true).id_;
	window.parent.addTab("修改系统资源访问表","修改系统资源访问表",basePath+"system/resourceManager/page/addResource.do?type=modify&id_="+id_,callback,true);
}

/**
 *创建更新系统资源访问表页签
 */
function removeData(){
	function success(data){
		message.info("删除系统资源访问表","删除成功！");
		page.doSearch();
	}
	
	function error(data){
		message.error("删除系统资源访问表","删除失败！");
	}
	
	var id_ = page.getSelectRows(true).id_;

	ajax.sendJsonRequest("POST",basePath+"system/resourceManager/deleteResource.do?id_="+id_,null,success,error);
			
}


function saveResource(){
	function success(data){
		message.info("添加系统资源访问表","保存成功！");
	}
	
	function error(data){
		message.error("添加系统资源访问表","保存失败！");
	}
	
	ajax.sendJsonRequest("POST",basePath+"system/resourceManager/addResource.do",$("#addResourceForm").serialize(),success,error);
}

function updateResource(){
	function success(data){
		message.info("更新系统资源访问表","更新成功！");
	}
	
	function error(data){
		message.error("更新系统资源访问表","更新失败！");
	}
	
	ajax.sendJsonRequest("POST",basePath+"system/resourceManager/updateResource.do",$("#addResourceForm").serialize(),success,error);
}
