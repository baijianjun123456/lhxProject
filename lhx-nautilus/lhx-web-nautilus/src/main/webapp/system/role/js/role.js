var columns  = [[
		{field:'name',title:'角色名称',width:300.0},
		{field:'desc_',title:'角色描述',width:500.0},
		{field:'status',title:'状态',width:500.0},
		]];

var tilte = "角色管理列表";

var page = null;
$(function(){
	if($("#type").val() == "list"){
		page = new Page("roleList","角色管理列表",columns,'add,remove,modify,roleAddMenu',basePath+"system/roleManager/ajaxlist.do","roleSearchForm");
		
		$("#submitid").click(function(){page.doSearch();});
	}
	
	if($("#saveRole").length > 0){
		$("#saveRole").click(function(){saveRole();});
	};
	
	if($("#clearRole").length > 0){
		$("#clearRole").click(function(){$("#addRoleForm").form('clear');});
	};
	
	if($("#saveRole").length > 0){
		$("#saveRole").click(function(){
			var type = $("#type").val();
			if(type == "add"){
				saveRole();
			}
			else if(type == "modify"){
				updateRole();
			}
		});
	}
});

/**
 * 创建新增角色管理页签
 */
function addData(){
	var addTabParam = {
			"tabId":     "添加角色管理",
			"title":     "添加角色管理",
			  "url":      basePath+"system/roleManager/page/addRole.do?type=add",
		 "isUpdate":      true
	};
	window.parent.addTab(addTabParam);
}

/**
 *创建更新角色管理页签
 */
function modifyData(){
	var id_ = page.getSelectRows(true).id_;
	var modifyTabParam = {
		  "tabId":     "修改角色管理",
		  "title":     "修改角色管理",
		  "url":      basePath+"system/roleManager/page/addRole.do?type=modify&id_="+id_,
	 "isUpdate":      true
	};
	
	window.parent.addTab(modifyTabParam);
}

/**
 *创建更新角色管理页签
 */
function removeData(){
	function success(data){
		message.info("删除角色管理","删除成功！");
		page.doSearch();
	}
	
	function error(data){
		message.error("删除角色管理","删除失败！");
	}
	
	var id_ = page.getSelectRows(true).id_;

	ajax.sendJsonRequest("POST",basePath+"system/roleManager/deleteRole.do?id_="+id_,null,success,error);
			
}

/**
 * 打开菜单配置界面
 */
function roleAddMenu(){
	var id_ = page.getSelectRows(true).id_;
	var modifyTabParam = {
		  "tabId":     "配置菜单",
		  "title":     "配置菜单",
		  "url":      basePath+"system/roleManager/page/roleAddMenu.do?type=roleAddMenu&roleId="+id_,
	 "isUpdate":      true
	};
	
	window.parent.addTab(modifyTabParam);
}

function saveRole(){
	function success(data){
		
		function backup(){
			resetFormType();
		}
		
		message.info("添加角色管理","保存成功！",backup);
	}
	
	function error(data){
		message.error("添加角色管理","保存失败！");
	}
	
	ajax.sendJsonRequest("POST",basePath+"system/roleManager/addRole.do",$("#addRoleForm").serialize(),success,error);
}

function updateRole(){
	function success(data){
		
		function backup(){
			window.parent.closeTab();
		}
		message.info("更新角色管理","更新成功！",backup);
	}
	
	function error(data){
		message.error("更新角色管理","更新失败！");
	}
	
	ajax.sendJsonRequest("POST",basePath+"system/roleManager/updateRole.do",$("#addRoleForm").serialize(),success,error);
}

function resetFormType(){
	$("#addRoleForm").form('clear');
}

function tabOnSelect(){
	if($("#type").val() == "list"){
		page.doSearch();
	}
}
