var columns  = [[
		/*{field:'tableName',title:'表单名称',width:150},*/
		{field:'columnName',title:'列名称',width:100},
		{field:'columnNameCh',title:'列描述',width:250},
		{field:'dataType',title:'数据类型',width:100},
		/*{field:'dataLength',title:'数据长度',width:100.0},*/
		{field:'displayLength',title:'显示长度',width:100.0},
		{field:'nullable5',title:'是否为空',width:50},
		{field:'isSearch',title:'搜索项',width:50},
		{field:'isList',title:'列项',width:50},
		{field:'isEdit',title:'编辑项',width:50},
		{field:'sourceType',title:'源类型',width:150},
		{field:'sourceValue',title:'源值',width:150.0}
		]];

var tilte = "表单管理列表";

var page = null;
$(function(){
	page = new Page("formList","表单管理列表",columns,'modify,init',basePath+"system/formManager/ajaxlist.do","formSearchForm");
	
	$("#submitid").click(function(){page.doSearch();});
	
	$("#saveForm").click(function(){saveform();});
	
	$("#clearForm").click(function(){$("#addFormForm").form('clear');});
	
	$("#tableMenuList").tree({"onClick":function(node){openFormFiled(node);}});

});

function openFormFiled(node){
	var node = $('#tableMenuList').tree('getSelected');
	$("#mainframe").attr("src",basePath+"system/formManager/page/formList.do?tableName="+node.id);
}

/**
 * 初始化表单数据；
 */
function initData(){
	
	function success(){
		message.info("表单管理","初始化成功！");
		page.doSearch();
	}
	ajax.sendJsonRequest("POST",basePath+"system/formManager/initFormFiled.do?tableName="+$("#tableName").val(),null,success,null);
}

/**
 * 创建新增表单管理页签
 */
function addData(){
	
	var parameter = {"id":"addFormFiled","title":"添加表字段","width":"500","height":"400","href":basePath+"system/formManager/page/addForm.do?tableName="+$("#tableName").val()};

	var dialog = new Dialog(parameter).create();
	
}

/**
 *创建更新表单管理页签
 */
function modifyData(){
	function callback(){
		page.doSearch();
	}
	var id_ = page.getSelectRows(true).id_;
	window.parent.addTab("修改表单管理","修改表单管理",basePath+"system/formManager/page/addForm.do?type=modify&id_="+id_,callback,true);
}

/**
 *创建更新表单管理页签
 */
function removeData(){
	function success(data){
		message.info("删除表单管理","删除成功！");
		page.doSearch();
	}
	
	function error(data){
		message.error("删除表单管理","删除失败！");
	}
	
	var id_ = page.getSelectRows(true).id_;

	ajax.sendJsonRequest("POST",basePath+"system/formManager/deleteForm.do?id_="+id_,null,success,error);
			
}


function saveForm(){
	function success(data){
		message.info("添加表单管理","保存成功！");
	}
	
	function error(data){
		message.error("添加表单管理","保存失败！");
	}
	
	ajax.sendJsonRequest("POST",basePath+"system/formManager/addForm.do",$("#addFormForm").serialize(),success,error);
}

function updateForm(){
	function success(data){
		message.info("更新表单管理","更新成功！");
	}
	
	function error(data){
		message.error("更新表单管理","更新失败！");
	}
	
	ajax.sendJsonRequest("POST",basePath+"system/formManager/updateForm.do",$("#addFormForm").serialize(),success,error);
}
