<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="/common/jsp/header.jsp"%>
<link rel="stylesheet" type="text/css" href="<%=basePath%>/common/css/common.css">

<script type="text/javascript"	src="<%=basePath%>system/user/js/userRole.js" ></script>
<body style="text-align:center;">
	<input type="hidden" value="${userId}" id="userId" name="userId"/> 
	<div >
		<div style="display:inline-block;margin:0px;">
			<div class="easyui-panel"  title="已选择角色"  style="width:500px;height:600px;">
				<select multiple="multiple" style="width:100%;height:100%;border-style:none" id="selected">
					<c:forEach var="role" items="${SELECTD}" varStatus="index">
						<option value="${role.id_}">${role.name}</option>
					</c:forEach>
				</select>
			</div>
		</div>
		<div style="display:inline-block;margin:0px;">
			<div class="easyui-panel"  title="操作"  style="width:200px;height:600px;">
				<div style="display:block;text-align:center;margin-top:250px">
					<a class="easyui-linkbutton buttonq" iconCls="icon-add" id="addRole">添加</a>
					</br>
					</br>
					<a class="easyui-linkbutton buttonq" iconCls="icon-remove" id="deleteRole">移除</a>
				</div>
				
			</div>
		</div>
		<div style="display:inline-block;margin:0px;">
			<div class="easyui-panel"  title="未选择角色"  style="width:500px;height:600px;">
				<select multiple="multiple" style="width:100%;height:100%;border-style:none" id="notSelect">
					<c:forEach var="role" items="${NOT_SELECT}" varStatus="index">
						<option value="${role.id_}" style="line-height:60px">${role.name}</option>
					</c:forEach>
				</select>
			</div>
		</div>
		<div style="padding-top:20px;">
			<a class="easyui-linkbutton buttonq" iconCls="icon-save" id="saveUserRoles">提交</a>
		</div>
	</div>	
</body>