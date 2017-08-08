<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="/common/jsp/header.jsp"%>
<link rel="stylesheet" type="text/css" href="<%=basePath%>/common/css/common.css">

<script type="text/javascript"	src="<%=basePath%>system/menu/js/menu.js" ></script>
<body style="width:99%;">
		<input type="hidden" id="type" value="${type}"/>
    	<form id="addMenuForm"  action="<%=basePath%>system/menuManager/addMenu.do"">
    		<input type="hidden" id="pid" name="pid" value="${pid}"/>
    		<input type="hidden" id="status" name="status" value="1"/>
			<div class="easyui-accordion " data-options="multiple:true" style="width:100%;height1:400px;" id="addForm">
					<input type="hidden" name = "id_" id="id_" value="${result.id_}" />
					
					<div title="菜单信息" data-options="iconCls:'icon-ok'" style="overflow:auto;padding:10px;">
						<table class="addTab" style="width:100%">
					    		<tr>
					    			<td class="title">菜单名称:</td><td><input class="easyui-textbox" type="text" name="name" value="${result.name}" data-options="required:true,width:250"></input></td>
					    			<td class="title">菜单编码:</td><td><input class="easyui-textbox" type="text" name="code" value="${result.code}" data-options="required:true,width:250" ></input></td>
					    			
					    		</tr>
					    	
					    		<tr>
					    			<td class="title">URL:</td><td><input class="easyui-textbox" type="text"  name="url" value="${result.url}" data-options="width:250,required:true"></input></td>
					    		<tr>
					    </table>
					</div>
			</div>
		</form>	
</body>
