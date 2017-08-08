<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="/common/jsp/header.jsp"%>
<link rel="stylesheet" type="text/css" href="<%=basePath%>/common/css/common.css">

<script type="text/javascript"	src="<%=basePath%>system/user/js/user.js" ></script>
<body style="width:99%;">
		<input type="hidden" id="type" value="${type}"/>
    	<form id="userSearchForm"  action="<%=basePath%>system/userManager/list.do"">
			<div class="easyui-accordion " data-options="multiple:true" style="width:100%;height1:300px;" id="searchq">
					<div title="查询条件" data-options="iconCls:'icon-ok'" style="overflow:auto;padding:10px;">
						<table class="searchTab" style="width:100%">
					    		<tr>
					    			<td class="title">用户名:</td><td><input isSearch="istrue" class="easyui-textbox content" type="text" name="name" value="${result.name}"></input></td>
					    			<td class="title">账号:</td><td><input isSearch="istrue" class="easyui-textbox content" type="text" name="accounts" value="${result.accounts}"></input></td>
					    			<td class="title">邮箱:</td><td><input isSearch="istrue" class="easyui-textbox content"  type="text" name="email" value="${result.email}"></input></td>
					    			<td class="title">手机:</td><td><input isSearch="istrue" class="easyui-textbox " type="text"  name="mobile" value="${result.mobile}"></input></td>
					    			<td class="title">状态:</td>
					    			<td>	
					    				<select class="easyui-combobox" name="status" style="width:200px;">  
					    					<option value="">全部</option>			
											<option value="0">删除</option>
											<option value="1">正常</option>
											<option value="2">停用</option>
											<option value="3">失效</option>
										</select>
									</td>
					    		</tr>
					    		<tr>
						    		<td colspan="10" style="text-align:center;"  >
						    			<a class="easyui-linkbutton buttonq" iconCls="icon-search" id="submitid">查询</a>
						    			<a class="easyui-linkbutton buttonq" iconCls="icon-reload">重置</a>
						    		</td>
					    		</tr>
					    </table>
					</div>
			</div>
		</form>	
	
		<table  id="userList" title="用户列表" data-options="rownumbers:true,singleSelect:true,iconCls:'icon-ok'" style="height:250px"   dataurl="<%=basePath%>system/userManager/ajaxlist.do" >
			<%-- <thead data-options="frozen:true">
				<tr>
					<th data-options="field:'name',width:200">用户名</th>
					<th data-options="field:'accounts',width:200">账号</th>
					<th data-options="field:'email',width:200">邮箱</th>
					<th data-options="field:'mobile',width:150">手机</th>
					<th data-options="field:'status',width:50">状态</th>
					<th data-options="field:'oper',width:2000" >操作</th>
				</tr>
			</thead>
		 	<tbody>
				<c:forEach var="user" items="${result.rows}" varStatus="index">
					<tr>
						<td>${user.name}</td>
						<td>${user.accounts}</td>
						<td>${user.email}</td>
						<td>${user.mobile}</td>
						<td>${user.status}</td>
						<td>
							<a class="easyui-linkbutton" iconCls="icon-edit"   >修改</a>
							<a  class="easyui-linkbutton" iconCls="icon-cancel" >删除</a>
							<a class="easyui-linkbutton" iconCls="icon-lock"   >停用</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
			 --%>
		</table>
	<%@ include file="/common/jsp/page.jsp"%> 
</body>