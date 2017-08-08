var columns  = [[
         		{field:'name',title:'资源名称',width:300},
         		{field:'url',title:'资源URL',width:600},
		]];

var tilte = "系统资源访问表列表";

var page = null;
$(function(){
	if($("#type").val() == "list"){
		page = new Page("resourceList","系统资源访问表列表",columns,'add,remove,modify',basePath+"system/resourceManager/ajaxlist.do","resourceSearchForm");
		
		$("#submitid").click(function(){page.doSearch();});
	}
	
	if($("#saveResource").length > 0){
		$("#saveResource").click(function(){saveResource();});
	};
	
	if($("#clearResource").length > 0){
		$("#clearResource").click(function(){$("#addResourceForm").form('clear');});
	};
	
	$("#resourceTreeList").tree({"onClick":function(node){openMenu(node);}});
});

function openMenu(node){
	var node = $('#resourceTreeList').tree('getSelected');
	$("#mainframe").attr("src",basePath+"system/resourceManager/page/resourceList.do?type=list&menuId="+node.id);
}

/**
 * 菜单树加载完成后执行函数；
 */
function treeLoadSucess(node,Data){
	$("#menuTreeList").tree("collapseAll");
	
}


/**
 * 创建新增系统资源访问表页签
 */
function addData(){

	var parameter = {"id":"addDict","title":"添加系统资源访问表","width":"800","height":"400","href":basePath+"system/resourceManager/page/addResource.do?type=add&menuId="+$("#menuId").val()};
	parameter["save"] = saveResource;
	new Dialog(parameter).create();
}

/**
 *创建更新系统资源访问表页签
 */
function modifyData(){
	var id_ = page.getSelectRows(true).id_;
	var parameter = {"title":"修改系统资源访问表","width":"800","height":"400","href":basePath+"system/resourceManager/page/addResource.do?type=modify&menuId="+$("#menuId").val()+"&id_="+id_};
	parameter["save"] = updateResource;
	new Dialog(parameter).create();
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
	
	if(!$("#addResource").form('validate')){
		return false;
	}
	
	ajax.sendJsonRequest("POST",basePath+"system/resourceManager/deleteResource.do?id_="+id_,null,success,error);
			
}


function saveResource(){
	function success(data){
		
		function backup(){
			page.doSearch();
		}
		
		message.info("添加系统资源访问表","保存成功！",backup);
	}
	
	function error(data){
		message.error("添加系统资源访问表","保存失败！");
	}
	
	if(!$("#addResource").form('validate')){
		return false;
	}
	
	ajax.sendJsonRequest("POST",basePath+"system/resourceManager/addResource.do",$("#addResourceForm").serialize(),success,error);
}

function updateResource(){
	function success(data){
		
		function backup(){
			page.doSearch();
		}
		
		message.info("更新系统资源访问表","更新成功！",backup);
	}
	
	function error(data){
		message.error("更新系统资源访问表","更新失败！");
	}
	
	ajax.sendJsonRequest("POST",basePath+"system/resourceManager/updateResource.do",$("#addResourceForm").serialize(),success,error);
}

function tabOnSelect(){
	if($("#type").val() == "list"){
		page.doSearch();
	}
}

function resetMenu(){
	$("#addMenuForm").form('clear');
}
