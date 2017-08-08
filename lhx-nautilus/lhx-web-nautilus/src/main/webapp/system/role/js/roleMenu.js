$(function(){
	
	//配置菜单
	if($("#type").val() == "roleAddMenu"){
		$("#saveRoleMenu").click(function(){saveRoleAddMenu();});
	}
});


/**
 * 保存菜单配置；
 */
function saveRoleAddMenu(){
	var roleId = $("#roleId").val();
	var selectedDataList = Tree.selectedNodes($('#roleMenuTreeList'),["id"],true);
	for(var index = 0; index < selectedDataList.length; index++){
		var selectedData = selectedDataList[index];
		selectedData["roleId"] = roleId;
		selectedData["menuId"] = selectedData.id;
		selectedData.id = null;
	}
	
	function success(data){
		
		function backup(){
			
		}
		
		message.info("配置菜单","保存成功！",backup);
	}
	
	function error(data){
		message.error("配置菜单","保存失败！");
	}
	ajax.sendJsonRequest("POST",basePath+"system/roleManager/saveRoleAddMenu.do",{"roleMenuStr":JSON.stringify(selectedDataList)},success,error);

}