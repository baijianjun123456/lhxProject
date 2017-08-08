var columns  = [[
		           //{field:'name',title:'用户名',width:100,hidden:false},
		           {field:'name',title:'用户名',width:300},
		           {field:'accounts',title:'账号',width:300},
		           {field:'email',title:'邮箱',width:300},
		           {field:'mobile',title:'手机',width:250},
		           {field:'status',title:'状态',width:150}
               ]];

var tilte = "菜单列表";

var page = null;
$(function(){
	
	page = new Page("menuList","菜单列表",columns,'add,remove,modify',basePath+"system/menuManager/ajaxlist.do","menuSearchForm");
	
	$("#submitid").click(function(){page.doSearch();});
	
	$("#saveMenu").click(function(){savemenu();});
	
	$("#clearMenu").click(function(){$("#addMenuForm").form('clear');});
});

/**
 * 创建新增菜单页签
 */
function addData(){
	function callback(){
		page.doSearch();
	}
	
	window.parent.addTab("添加@moduleNameCH","添加@moduleNameCH",basePath+"system/menuManager/page/addMenu.do?type=add",callback,true);
}

/**
 *创建更新菜单页签
 */
function modifyData(){
	function callback(){
		page.doSearch();
	}
	var id_ = page.getSelectRows(true).id_;
	window.parent.addTab("修改菜单","修改菜单",basePath+"system/menuManager/page/addMenu.do?type=modify&id_="+id_,callback,true);
}

/**
 *创建更新菜单页签
 */
function removeData(){
	function success(data){
		message.info("删除菜单","删除成功！");
		page.doSearch();
	}
	
	function error(data){
		message.error("删除菜单","删除失败！");
	}
	
	var id_ = page.getSelectRows(true).id_;

	ajax.sendJsonRequest("POST",basePath+"system/menuManager/deleteMenu.do?id_="+id_,null,success,error);
			
}


function saveMenu(){
	function success(data){
		message.info("添加菜单","保存成功！");
	}
	
	function error(data){
		message.error("添加菜单","保存失败！");
	}
	
	ajax.sendJsonRequest("POST",basePath+"system/menuManager/addMenu.do",$("#addMenuForm").serialize(),success,error);
}

function updateMenu(){
	function success(data){
		message.info("更新菜单","更新成功！");
	}
	
	function error(data){
		message.error("更新菜单","更新失败！");
	}
	
	ajax.sendJsonRequest("POST",basePath+"system/menuManager/updateMenu.do",$("#addMenuForm").serialize(),success,error);
}
