var columns  = [[
		{field:'formName',title:'表单名称',width:300},
		{field:'formCode',title:'表单编码',width:200},
		{field:'formDesc',title:'表单说明',width:500}
		]];

var tilte = "表单定义列表";

var page = null;
$(function(){
	
	if($("#type").val() == "list"){
		
		page = new Page("formDefList","表单定义列表",columns,'add,remove,modify',basePath+"system/formDefManager/ajaxlist.do","formDefSearchForm");
		
		$("#submitid").click(function(){page.doSearch();});
	}
	
	if($("#formTypeMenu").length > 0){
		$("#formTypeMenu").tree({"onClick":function(node){openFormDef(node);}});
	}
});



function openFormDef(node){
	var node = $('#formTypeMenu').tree('getSelected');
	$("#mainframe").attr("src",basePath+"system/formDefManager/page/formDefList.do?type=list&formType="+node.attributes.form_type);
}

/**
 * 创建新增表单定义页签
 */
function addData(){
	var parameter = {"title":"添加表单","width":"800","height":"300","href":basePath+"system/formDefManager/page/addFormDef.do?type=add&formType="+$("#formType").val()};
	parameter["save"] = saveFormDef;
	new Dialog(parameter).create();
}

/**
 * 重置表单
 */
function clearData(){
	$("#addFormDefForm").form('clear');
}

/**
 *创建更新表单定义页签
 */
function modifyData(){

	var id_ = page.getSelectRows(true).id_;
	var parameter = {"title":"修改表单定义","width":"800","height":"300","href":basePath+"system/formDefManager/page/addFormDef.do?type=modify&id_="+id_};
	parameter["save"] = updateFormDef;
	new Dialog(parameter).create();
}

/**
 *创建更新表单定义页签
 */
function removeData(){
	function success(data){
		message.info("删除表单定义","删除成功！");
		page.doSearch();
	}
	
	function error(data){
		message.error("删除表单定义","删除失败！");
	}
	
	var id_ = page.getSelectRows(true).id_;

	ajax.sendJsonRequest("POST",basePath+"system/formDefManager/deleteFormDef.do?id_="+id_,null,success,error);
			
}


function saveFormDef(){
	function success(data){
		message.info("添加表单定义","保存成功！");
		page.doSearch();
	}
	
	function error(data){
		message.error("添加表单定义","保存失败！");
	}
	
	ajax.sendJsonRequest("POST",basePath+"system/formDefManager/addFormDef.do",$("#addFormDefForm").serialize(),success,error);
}

function updateFormDef(){
	function success(data){
		message.info("更新表单定义","更新成功！");
		page.doSearch();
	}
	
	function error(data){
		message.error("更新表单定义","更新失败！");
	}
	
	ajax.sendJsonRequest("POST",basePath+"system/formDefManager/updateFormDef.do",$("#addFormDefForm").serialize(),success,error);
}
