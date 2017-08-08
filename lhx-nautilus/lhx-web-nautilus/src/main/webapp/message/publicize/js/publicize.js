var columns  = [[
		           //{field:'name',title:'用户名',width:100,hidden:false},
		           {field:'title',title:'公告名',width:300},
		           {field:'member',title:'发送人',width:300},
		           {field:'abstrac',title:'简介',width:300},
		           {field:'level',title:'公告级别',width:250},
		           {field:'status',title:'状态',width:150}
               ]];

var tilte = "公告列表";

var page = null;
$(function(){
	if($("#type").val() == "list"){
		page = new Page("publicizeList","公告列表",columns,'add,remove,modify,detail',basePath+"message/publicize/ajaxlist.do","publicizeSearchForm");
		$("#submitid").click(function(){page.doSearch();});
	}
	
	if($("#clearUser").length > 0){
		$("#clearUser").click(function(){$("#addPublicizeForm").form('clear');});
	}
	if($("#savePublicize").length > 0){				
		$("#savePublicize").click(function(){			
			var type = $("#type").val();
			if(type == "add"){				
				savePulicize();
			}
			else if(type == "modify"){						
				updatePublicize();
			}
		});
	}
});

/**
 * 创建新增用户页签
 */
function addData(){		
	var addTabParam = {
			"tabId":     "添加公告",
			"title":     "添加公告",
			  "url":      basePath+"message/publicize/page/addPublicize.do?type=add",
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
			  "tabId":     "修改公告",
			  "title":     "修改公告",
			  "url":      basePath+"message/publicize/page/addPublicize.do?type=modify&id_="+id_,
		 "isUpdate":      true
		};
		
	window.parent.addTab(modifyTabParam);
}
/**
 *创建更新用户页签
 */
function detailData(){
	var id_ = page.getSelectRows(true).id_;
	var modifyTabParam = {
			  "tabId":     "修改公告",
			  "title":     "修改公告",
			  "url":      basePath+"message/publicize/page/publicizeDetail.do?type=modify&id_="+id_,
		 "isUpdate":      true
		};
		
	window.parent.addTab(modifyTabParam);
}
/**
 *创建更新用户页签
 */
function removeData(){
	function success(data){
		message.info("删除公告","删除成功！");
		page.doSearch();
	}
	
	function error(data){
		message.error("删除公告","删除失败！");
	}
	
	var id_ = page.getSelectRows(true).id_;

	ajax.sendJsonRequest("POST",basePath+"message/publicize/deletePublicize.do?id_="+id_,null,success,error);
			
}


function savePulicize(){
	function success(data){
		function backup(){
			resetUser();
		}
		message.info("添加公告","保存成功！",backup);
	}
	
	function error(data){
		message.error("添加公告","保存失败！");
	}
	
	ajax.sendJsonRequest("POST",basePath+"message/publicize/addPublicize.do?roleIdStr="+$('#roleid').combobox('getValues'),$("#addPublicizeForm").serialize(),success,error);
}

function updatePublicize(){	
	function success(data){
		function backup(){
			window.parent.closeTab();
		}
		
		message.info("更新公告","更新成功！",backup);
	}
	
	function error(data){
		message.error("更新公告","更新失败！");
	}	
	ajax.sendJsonRequest("POST",basePath+"message/publicize/updatPublicize.do?roleIdStr="+$('#roleid').combobox('getValues'),$("#addPublicizeForm").serialize(),success,error);
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
	$("#addPublicizeForm").form('clear');
}

