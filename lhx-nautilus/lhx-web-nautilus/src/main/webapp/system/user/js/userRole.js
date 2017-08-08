$(function(){
	$("#addRole").click(function(){
		changeOption("notSelect","selected");
	}); 
	
	$("#deleteRole").click(function(){
		changeOption("selected","notSelect");
	});
	
	$("#selected").find("option").each(function(i,item){
		$(item).click(function(){
			changeOption("selected","notSelect");
		});
	});
	
	$("#saveUserRoles").click(function(){
		saveUserRoles("selected","notSelect");
	}); 

	$("#notSelect").find("option").dblclick(function(){
		changeOption("notSelect","selected");
	});

});

function changeOption(srcId,descId){
	var roleId = $("#"+srcId).val();
	if(roleId == ''){
		return;
	}
	var roleName = $("#"+srcId).find("option:checked").html();
	$("#"+descId).append("<option value="+roleId+">"+roleName+"</option>");
	$("#"+srcId).find("option:checked").remove();
}

function saveUserRoles(){
	var userRoleList = [];
	var userId = $("#userId").val();
	$("#selected").find("option").each(function(i,item){
		var roleId = $(item).val();
		userRoleList[i] = {};
		userRoleList[i]["userId"] = userId;
		userRoleList[i]["roleId"] = roleId;
	});
	
	function success(data){
		function backup(){
			window.parent.closeTab();
		}
		
		message.info("配置角色","配置角色成功！",backup);
	}
	
	function error(){
		
	}
	ajax.sendJsonRequest("POST",basePath+"system/userManager/saveUserRoles.do",{"userRoleStr":JSON.stringify(userRoleList)},success,error);
	
}
