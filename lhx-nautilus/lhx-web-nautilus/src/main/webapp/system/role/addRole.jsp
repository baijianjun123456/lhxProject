<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="/common/jsp/header.jsp"%>
<link rel="stylesheet" type="text/css" href="<%=basePath%>/common/css/common.css">

<script type="text/javascript"	src="<%=basePath%>system/role/js/role.js" ></script>
<body style="width:99%;">
	   <input type="hidden" id="type" value="${type}"/>
    	<form id="addRoleForm"  action="<%=basePath%>system/roleManager/addRole.do"">
			<div class="easyui-accordion " data-options="multiple:true" style="width:60%;height1:300px;" id="addForm">
					<input type="hidden" name = "id_" id="id_" value="${result.id_}" />
					
					<div title="角色管理信息" data-options="iconCls:'icon-ok'" style="overflow:auto;padding:10px;">
						<table class="addTab" style="width:100%">
					    		<tr>
					    			<td class="title">角色名称:</td><td><input class="easyui-textbox" type="text" name="name" value="${result.name}" data-options="required:true,width:250,validType:'maxLength[30]'"></input></td>
					    			
					    			<td class="title">角色编码:</td><td><input class="easyui-textbox" type="text" name="code" value="${result.code}" data-options="required:true,width:250,validType:'maxLength[30]'"></input></td>
					    			
					    		</tr>
					    		<tr>
					    			<td class="title">状态:</td>
					    			<td>
					    				<select class="easyui-combobox" name="status" style="width:200px;">  
											<option value="0">删除</option>
											<option value="1" selected>正常</option>
											<option value="2">停用</option>
										</select>
					    			</td>
					    			<td class="title">角色描述:</td><td ><input class="easyui-textbox" type="text" name="desc_" value="${result.desc_}" data-options="width:250,height:75,validType:'maxLength[130]',multiline:true"></input></td>					    			
					    		</tr>
					    		<tr>
						    		<td colspan="10" style="text-align:center;" >
						    			<a class="easyui-linkbutton buttonq" iconCls="icon-save" id="saveRole">提交</a>
						    			<c:if test="${type eq 'add'}" >
						    				<a class="easyui-linkbutton buttonq" iconCls="icon-reload" id="clearRole">清空</a>
						    			</c:if>
						    		</td>
					    		</tr>
					    </table>
					</div>
			</div>
		</form>	
</body>
