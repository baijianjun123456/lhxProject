<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="/common/jsp/header.jsp"%>
<link rel="stylesheet" type="text/css" href="<%=basePath%>/common/css/common.css">

<script type="text/javascript"	src="<%=basePath%>system/menu/jsp/js/menu.js" ></script>
<body style="width:99%;">
    	<form id="addMenuForm"  action="<%=basePath%>system/menuManager/addMenu.do"">
			<div class="easyui-accordion " data-options="multiple:true" style="width:60%;height1:300px;" id="addForm">
					<input type="hidden" name = "id_" id="id_" value="${result.id_}" />
					
					<div title="菜单信息" data-options="iconCls:'icon-ok'" style="overflow:auto;padding:10px;">
						<table class="addTab" style="width:100%">
					    		<tr>
					    			<td class="title">用户名:</td><td><input class="easyui-textbox" type="text" name="name" value="${result.name}" data-options="required:true,width:250"></input></td>
					    			<td class="title">登录账号:</td><td><input class="easyui-textbox" type="text" name="accounts" value="${result.accounts}" data-options="required:true,width:250" validType="checkIsExist"></input></td>
					    			
					    		</tr>
					    		<c:if test="${type eq 'add'}" >
						    		<tr>
						    			<td class="title">密码:</td><td><input class="easyui-textbox" type="password" name="password" id="password" value="${result.name}" data-options="required:true,validType:'length[6,16]',width:250"></input></td>
						    			<td class="title">确认密码:</td><td><input class="easyui-textbox" type="password" name="password2" value="${result.accounts}" data-options="required:true,width:250" validType="eqPwd['#password']"></input></td>
						    		</tr>
					    		</c:if>
					    		<tr>
					    		</tr>
					    			<td class="title">手机:</td><td><input class="easyui-textbox" type="text"  name="mobile" value="${result.mobile}" data-options="width:250,required:true,validType:'mobile'"></input></td>
					    			<td class="title">邮箱:</td><td><input class="easyui-textbox"  type="text" name="email" value="${result.email}" data-options="validType:'email',width:250"  ></input></td>
					    		<tr>
					    			<td class="title">QQ:</td><td><input class="easyui-textbox" type="text"  name="qq" value="${result.qq}" data-options="width:250,validType:'qq'"></input></td>
					    			<td class="title">微信:</td><td><input class="easyui-textbox" type="text"  name="wx" value="${result.wx}" data-options="width:250"></input></td>
					    		</tr>
					    		<tr>
					    			<td class="title">状态：</td>		    			
					    			<td>	
					    				<select class="easyui-combobox" name="status" data-options="width:250">  
					    					<option value="">全部</option>			
											<option value="0">删除</option>
											<option value="1" selected>正常</option>
											<option value="2">停用</option>
											<option value="3">失效</option>
										</select>
									</td>
					    			<td class="title">性别：</td><td  class="radioSpan"><input type="radio" value="0"  name="sex" checked>男</input> <input type="radio" value="1"  name="sex" >女</input></td>		

					    		</tr>

					    		<tr>
						    		<td colspan="10" style="text-align:center;" >
						    			<a class="easyui-linkbutton buttonq" iconCls="icon-save" id="saveUser">提交</a>
						    			<c:if test="${type eq 'add'}" >
						    				<a class="easyui-linkbutton buttonq" iconCls="icon-reload" id="clearUser">清空</a>
						    			</c:if>
						    		</td>
					    		</tr>
					    </table>
					</div>
			</div>
		</form>	
</body>
