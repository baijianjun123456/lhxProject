var columns  = [[
		{field:'name',title:'菜单名称',width:200.0},
		{field:'code',title:'菜单编码',width:200.0},
		{field:'url',title:'URL',width:500.0},
		{field:'orderBy',title:'排序',width:100}
		]];

var tilte = "菜单列表";

var page = null;
$(function(){
	if($("#type").val() == "list"){
		page = new Page("menuList","菜单列表",columns,'add,remove,modify',basePath+"system/menuManager/ajaxlist.do?pid="+$("#pid").val(),"menuSearchForm");
		
		$("#submitid").click(function(){page.doSearch();});
	}
	
	if($("#clearMenu").length > 0){
		$("#clearMenu").click(function(){$("#addMenuForm").form('clear');});
	};
	
	if($("#saveMenu").length > 0){
		$("#saveMenu").click(function(){
			var type = $("#type").val();
			if(type == "add"){
				saveMenu();
			}
			else if(type == "modify"){
				updateMenu();
			}
		});
	}
	
	$("#menuTreeList").tree({"onClick":function(node){openMenu(node);}});
});

function openMenu(node){
	var node = $('#menuTreeList').tree('getSelected');
	$("#mainframe").attr("src",basePath+"system/menuManager/page/menuList.do?type=list&menuId="+node.id);
}

/**菜单字典树加载完成后执行函数；
 */
function treeLoadSucess(node,Data){
	$("#menuTreeList").tree("collapseAll");
	
}


/**
 * 创建新增菜单页签
 */
function addData(){
	var parameter = {"id":"addDict","title":"添加菜单","width":"800","height":"400","href":basePath+"system/menuManager/page/addMenu.do?type=add&pid="+$("#pid").val()};
	parameter["save"] = saveMenu;
	new Dialog(parameter).create();
}

/**
 *创建更新菜单页签
 */
function modifyData(){	
	var id_ = page.getSelectRows(true).id_;
	var parameter = {"title":"修改菜单","width":"800","height":"400","href":basePath+"system/menuManager/page/addMenu.do?type=modify&pid="+$("#pid").val()+"&id_="+id_};
	parameter["save"] = updateMenu;
	new Dialog(parameter).create();
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
	
		function backup(){
			page.doSearch();
		}
		
		message.info("添加菜单","保存成功！",backup);
	}
	
	function error(data){
		message.error("添加菜单","保存失败！");
	}
	
	
	if(!$("#addMenuForm").form('validate')){
		return false;
	}
	
	ajax.sendJsonRequest("POST",basePath+"system/menuManager/addMenu.do",$("#addMenuForm").serialize(),success,error);
}

function updateMenu(){
	function success(data){
		
		function backup(){
			page.doSearch();
		}

		message.info("更新菜单","更新成功！",backup);
	}
	
	function error(data){
		message.error("更新菜单","更新失败！");
	}
	
	if(!$("#addMenuForm").form('validate')){
		return false;
	}
	ajax.sendJsonRequest("POST",basePath+"system/menuManager/updateMenu.do",$("#addMenuForm").serialize(),success,error);
}

function tabOnSelect(){
	if($("#type").val() == "list"){
		page.doSearch();
	}
}


function resetMenu(){
	$("#addMenuForm").form('clear');
}
