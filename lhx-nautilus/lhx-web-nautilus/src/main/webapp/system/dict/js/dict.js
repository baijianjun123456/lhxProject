var columns  = [[
         		{field:'name',title:'名称',width:200},
         		/*{field:'i18n',title:'国际化',width:200},*/
         		{field:'code',title:'编码',width:200},
         		{field:'value',title:'编码值',width:200},
         		{field:'pcode',title:'父节点',width:200}
		]];

var tilte = "数据字典列表";

var page = null;
$(function(){
	if($("#type").val() == "list"){
		page = new Page("dictList","数据字典列表",columns,'add,remove,modify',basePath+"system/dictManager/ajaxlist.do","dictSearchForm");
		
		$("#submitid").click(function(){page.doSearch();});
	}
	
	if($("#clearDict").length > 0){
		$("#clearDict").click(function(){$("#addDictForm").form('clear');});
	};
	
	if($("#saveDict").length > 0){
		$("#saveDict").click(function(){
			var type = $("#type").val();
			if(type == "add"){
				saveDict();
			}
			else if(type == "modify"){
				updateDict();
			}
		});
	}
	
	$("#dictTreeList").tree({"onClick":function(node){openDict(node);}});

});

function openDict(node){
	var node = $('#dictTreeList').tree('getSelected');
	$("#mainframe").attr("src",basePath+"system/dictManager/page/dictList.do?type=list&pcode="+node.id);
}

/**
 * 字典树加载完成后执行函数；
 */
function treeLoadSucess(node,Data){
	$("#dictTreeList").tree("collapseAll");
	
}

/**
 * 创建新增数据字典页签
 */
function addData(){
	
	var parameter = {"id":"addDict","title":"添加数据字典","width":"800","height":"400","href":basePath+"system/dictManager/page/addDict.do?pcode="+$("#pcode").val()};
	parameter["save"] = saveDict;
	new Dialog(parameter).create();
}

/**
 *创建更新数据字典页签
 */
function modifyData(){
	var id_ = page.getSelectRows(true).id_;
	var parameter = {"title":"修改数据字典","width":"800","height":"400","href":basePath+"system/dictManager/page/addDict.do?type=modify&id_="+id_};
	parameter["save"] = updateDict;
	new Dialog(parameter).create();
}

/**
 *创建更新数据字典页签
 */
function removeData(){
	function success(data){
		message.info("删除数据字典","删除成功！");
		page.doSearch();
		Tree.refresh(getTree(),$("#pcode").val());
	}
	
	function error(data){
		message.error("删除数据字典","删除失败！");
	}
	
	var id_ = page.getSelectRows(true).id_;

	ajax.sendJsonRequest("POST",basePath+"system/dictManager/deleteDict.do?id_="+id_,null,success,error);
			
}


function saveDict(){
	function success(data){
	
		function backup(){
			page.doSearch();
			Tree.refresh(getTree(),$("#pcode").val());
		}
		
		message.info("添加数据字典","保存成功！",backup);
	}
	
	function error(data){
		message.error("添加数据字典","保存失败！");
	}
	
	if(!$("#addDictForm").form('validate')){
		return false;
	}
	
	ajax.sendJsonRequest("POST",basePath+"system/dictManager/addDict.do",$("#addDictForm").serialize(),success,error);
}

function updateDict(){
	function success(data){
		
		function backup(){
			page.doSearch();
			Tree.refresh(getTree(),$("#pcode").val());
		}
		
		message.info("更新数据字典","更新成功！",backup);
	}
	
	function error(data){
		message.error("更新数据字典","更新失败！");
	}
	
	if(!$("#addDictForm").form('validate')){
		return false;
	}
	
	ajax.sendJsonRequest("POST",basePath+"system/dictManager/updateDict.do",$("#addDictForm").serialize(),success,error);
}

function tabOnSelect(){
	if($("#type").val() == "list"){
		page.doSearch();
	}
}

function resetDict(){
	$("#addDictForm").form('clear');
}

function getTree(){
	return parent.window.$("#dictTreeList");
}
