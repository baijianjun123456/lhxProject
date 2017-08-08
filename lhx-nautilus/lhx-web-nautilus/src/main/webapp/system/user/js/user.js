var columns  = [[
		           //{field:'name',title:'用户名',width:100,hidden:false},
		           {field:'name',title:'用户名',width:300},
		           {field:'accounts',title:'账号',width:300},
		           {field:'email',title:'邮箱',width:300},
		           {field:'mobile',title:'手机',width:250},
		           {field:'statusName',title:'状态',width:150}
               ]];

var tilte = "用户列表";

var page = null;
$(function(){
	if($("#type").val() == "list"){
		page = new Page("userList","用户列表",columns,'add,remove,modify,userAddRole',basePath+"system/userManager/ajaxlist.do","userSearchForm");
		$("#submitid").click(function(){page.doSearch();});
	}
	
	if($("#clearUser").length > 0){
		$("#clearUser").click(function(){$("#addUserForm").form('clear');});
	}
	
	if($("#saveUser").length > 0){
		$("#saveUser").click(function(){
			var type = $("#type").val();
			if(type == "add"){
				saveUser();
			}
			else if(type == "modify"){
				updateUser();
			}
		});
	}
});

/**
 * 创建新增用户页签
 */
function addData(){
	var addTabParam = {
			"tabId":     "添加用户",
			"title":     "添加用户",
			  "url":      basePath+"system/userManager/page/addUser.do?type=add",
		 "isUpdate":      true
	};
	window.parent.addTab(addTabParam);
}

/**
 *创建更新用户页签
 */
function modifyData(){
	var id_ = page.getSelectRows(true).id_;
	var modifyTabParam = {
			  "tabId":     "添加用户",
			  "title":     "添加用户",
			  "url":      basePath+"system/userManager/page/addUser.do?type=modify&id_="+id_,
		 "isUpdate":      true
		};
		
	window.parent.addTab(modifyTabParam);
}


function userAddRole(){
	var selectRow = page.getSelectRows(true);
	var id_ = selectRow.id_;
	var accounts =  selectRow.accounts;
	var userAddRoleParam = {
			  "tabId":     "配置角色",
			  "title":     "配置角色（"+accounts+")",
			  "url":      basePath+"system/userManager/page/userAddRole.do?userId="+id_,
			  "isUpdate":      true
		};	
	window.parent.addTab(userAddRoleParam);
}


/**
 *创建更新用户页签
 */
function removeData(){
	function success(data){
		message.info("删除用户","删除成功！");
		page.doSearch();
	}
	
	function error(data){
		message.error("删除用户","删除失败！");
	}
	
	var id_ = page.getSelectRows(true).id_;

	ajax.sendJsonRequest("POST",basePath+"system/userManager/deleteUser.do?id_="+id_,null,success,error);
			
}

function saveUser(){
	function success(data){
		function backup(){
			resetUser();
		}
		message.info("添加用户","保存成功！",backup);
	}
	
	function error(data){
		message.error("添加用户","保存失败！");
	}
	
	ajax.sendJsonRequest("POST",basePath+"system/userManager/addUser.do",$("#addUserForm").serialize(),success,error);
}

function updateUser(){
	function success(data){
		function backup(){
			window.parent.closeTab();
		}
		
		message.info("更新用户","更新成功！",backup);
	}
	
	function error(data){
		message.error("更新用户","更新失败！");
	}
	
	ajax.sendJsonRequest("POST",basePath+"system/userManager/updateUser.do",$("#addUserForm").serialize(),success,error);
}


$.extend($.fn.validatebox.defaults.rules, {
	checkIsExist : {
        validator : function(value) {
        	try{
        		var isExist = true;
        		function success(data){
        			var id_ = $("#id_").val();
        			if(id_  && data.id_ && id_ != data.id_){
        				isExist = false;
        			}

        			if(!id_ && data.flag == "true"){
        				isExist = false;
        			}
        			
        		}
	        	ajax.sendJsonRequest("POST",basePath+"system/userManager/checkIsExist.do?accounts="+value,null,success,null,false);
	        	return isExist;
        	}catch(ex){
        		
        	}
        	
        },
        message : '当前登录账号已被占用！'
    }	
});

function tabOnSelect(){
	if($("#type").val() == "list"){
		page.doSearch();
	}
}


function resetUser(){
	$("#addUserForm").form('clear');
}