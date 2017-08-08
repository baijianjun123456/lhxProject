<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="/common/jsp/header.jsp"%>
<link rel="stylesheet" type="text/css" href="<%=basePath%>/common/css/common.css">

<script type="text/javascript"	src="<%=basePath%>system/formType/js/formType.js" ></script>
<body style="width:99%;">
		<input type="hidden" id="type" value="${type}"/>
    	<form id="addFormTypeForm"  action="<%=basePath%>system/formTypeManager/addFormType.do"">
			<div class="easyui-accordion " data-options="multiple:true" style="width:60%;height1:300px;" id="addForm">
					<input type="hidden" name = "id_" id="id_" value="${result.id_}" />
					
					<div title="表单分类信息" data-options="iconCls:'icon-ok'" style="overflow:auto;padding:10px;">
						<table class="addTab" style="width:100%">
					    		<tr>
					    			<td class='title'>分类名称:</td><td><input isSearch='istrue' class='easyui-textbox content' type='text' name=name value='${result.name}' data-options="required:true,width:250,validType:'maxLength[30]'"></input></td>
									<td class='title'>分类编码:</td><td><input isSearch='istrue' class='easyui-textbox content' type='text' name=code value='${result.code}' data-options="required:true,width:250,validType:'maxLength[30]'"></input></td>
					    		</tr>
					    		<tr>
						    		<td colspan="10" style="text-align:center;" >
						    			<a class="easyui-linkbutton buttonq" iconCls="icon-save" id="saveFormType">提交</a>
						    		</td>
					    		</tr>
					    </table>
					</div>
			</div>
		</form>	
</body>
