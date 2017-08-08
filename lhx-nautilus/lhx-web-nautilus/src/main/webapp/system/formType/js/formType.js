var columns  = [[
         		{field:'name',title:'分类名称',width:400},
         		{field:'code',title:'分类编码',width:400},
         		{field:'status',title:'状态',width:200}
		]];

var tilte = "表单分类列表";

var page = null;
$(function(){
	
	if($("#type").val() == "list"){
		page = new Page("formTypeList","表单分类列表",columns,'add,remove,modify',basePath+"system/formTypeManager/ajaxlist.do","formTypeSearchForm");
		
		$("#submitid").click(function(){page.doSearch();});

	}
	
	if($("#saveFormType").length > 0){
		$("#saveFormType").click(function(){
			var type = $("#type").val();
			if(type == "add"){
				saveFormType();
			}
			else if(type == "modify"){
				updateFormType();
			}
		});
	}
});

function tabOnSelect(){
	if($("#type").val() == "list"){
		page.doSearch();
	}
}

/**
 * 创建新增表单分类页签
 */
function addData(){
	var addTabParam = {
			"tabId":     "添加表单分类",
			"title":     "添加表单分类",
			  "url":      basePath+"system/formTypeManager/page/addFormType.do?type=add",
		 "isUpdate":      true
	};
	window.parent.addTab(addTabParam);
}

/**
 *创建更新表单分类页签
 */
function modifyData(){
	function callback(){
		page.doSearch();
	}
	var id_ = page.getSelectRows(true).id_;
	
	var modifyTabParam = {
			"tabId":     "修改表单分类",
			"title":     "修改表单分类",
			  "url":      basePath+"system/formTypeManager/page/addFormType.do?type=modify&id_="+id_,
		 "isUpdate":      true
	};
	
	window.parent.addTab(modifyTabParam);
}

/**
 *创建更新表单分类页签
 */
function removeData(){
	function success(data){
		message.info("删除表单分类","删除成功！");
		page.doSearch();
	}
	
	function error(data){
		message.error("删除表单分类","删除失败！");
	}
	
	var id_ = page.getSelectRows(true).id_;

	ajax.sendJsonRequest("POST",basePath+"system/formTypeManager/deleteFormType.do?id_="+id_,null,success,error);
			
}


function saveFormType(){
	function success(data){
		
		function backup(){
			resetFormType();
		}
		message.info("添加表单分类","保存成功！",backup);

	}
	
	function error(data){
		message.error("添加表单分类","保存失败！");
	}
	
	if(!$("#addFormTypeForm").form('validate')){
		return false;
	}
	
	ajax.sendJsonRequest("POST",basePath+"system/formTypeManager/addFormType.do",$("#addFormTypeForm").serialize(),success,error);
}

function updateFormType(){
	function success(data){
		
		function backup(){
			window.parent.closeTab();
		}
		
		message.info("更新表单分类","更新成功！",backup);
	}
	
	function error(data){
		message.error("更新表单分类","更新失败！");
	}
	
	if(!$("#addFormTypeForm").form('validate')){
		return false;
	}
	ajax.sendJsonRequest("POST",basePath+"system/formTypeManager/updateFormType.do",$("#addFormTypeForm").serialize(),success,error);
}

function resetFormType(){
	$("#addFormTypeForm").form('clear');
}
