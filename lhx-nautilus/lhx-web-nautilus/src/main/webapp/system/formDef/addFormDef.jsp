<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="/common/jsp/header.jsp"%>
<link rel="stylesheet" type="text/css" href="<%=basePath%>/common/css/common.css">

<body style="width:99%;">
    	<form id="addFormDefForm"  action="<%=basePath%>system/formDefManager/addFormDef.do"">
			<div class="easyui-accordion " data-options="multiple:true" style="width:100%;height1:300px;" id="addForm">
				<input type="hidden" name = "id_" id="id_" value="${result.id_}" />
				
					<table class="addTab" style="width:100%;height:200px;">
				    		<tr>
				    			<td class="title">表单名称:</td><td><input class="easyui-textbox" type="text" name="formName" value="${result.formName}" data-options="required:true,width:250,validType:'maxLength[30]'"></input></td>
				    			<td class="title">表单分类:</td><td><input class="easyui-textbox" type="text" name="formType" value="${empty formType ? result.formType : formType}" data-options="required:true,width:250,validType:'maxLength[30]'" ></input></td>
				    			
				    		</tr>
				    		<tr>
				    			<td class="title">表单编码:</td><td><input class="easyui-textbox" type="text" name="formCode" value="${result.formCode}" data-options="required:true,width:250,validType:'maxLength[30]'"></input></td>
				    			<td class="title">表单描述:</td><td><input class="easyui-textbox" type="text" name="formDesc" value="${result.formDesc}" data-options="width:250,height:75,validType:'maxLength[130]',multiline:true"></input></td>
				    			
				    		</tr>

				    </table>
				</div>
		</form>	
</body>
