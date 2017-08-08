<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="/common/jsp/header.jsp"%>
<link rel="stylesheet" type="text/css" href="<%=basePath%>/common/css/common.css">

<script type="text/javascript"	src="<%=basePath%>system/role/js/roleMenu.js" ></script>
<body style="width:99%;">
	   <input type="hidden" id="type" value="${type}"/>
    	<form id="roleMenuForm"  action="<%=basePath%>system/roleManager/addRole.do" >
			<div class="easyui-accordion " data-options="multiple:true" style="width:100%;height1:300px;" id="addForm">
					<input type="hidden" name = "roleId" id="roleId" value="${roleId}" />
					<div data-options="region:'west',split:true" title="菜单" style="width:13%">
						<div class="easyui-panel" style="padding:5px" >
						    <div style="margin:10px">
								<input class="easyui-searchbox" data-options="prompt:'请输入菜单名称检索'" style="width:95%"></input>
							</div>
							<ul class="easyui-tree" id="roleMenuTreeList" data-options="url:'<%=basePath%>system/treeManager/ajaxJson.do?serviceName=MenuTreeByRoleService&roleId=${roleId}',method:'get',animate:true,'state':'closed',checkbox:true">
								
							</ul>
						</div>
					</div>

			</div>
			<div style="width:100%;text-align:center;padding-top:10px;">
					<a class="easyui-linkbutton buttonq" iconCls="icon-save" id="saveRoleMenu">提交</a>
			</div>
		</form>	
</body>
