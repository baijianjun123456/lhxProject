<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="/common/jsp/header.jsp"%>
<link rel="stylesheet" type="text/css" href="<%=basePath%>/common/css/common.css">

<script type="text/javascript"	src="<%=basePath%>system/dict/js/dict.js" ></script>
<body style="width:99%;">
		<input type="hidden" id="type" value="${type}"/>

    	<form id="addDictForm"  action="<%=basePath%>system/dictManager/addDict.do">
    		<input type="hidden" id="pcode" name="pcode" value="${pcode}"/>
			<div class="easyui-accordion " data-options="multiple:true" style="width:100%;height1:300px;" id="addForm">
					<input type="hidden" name = "id_" id="id_" value="${result.id_}" />
					<table class="addTab" style="width:100%">
				    		<tr>
				    			<td class="title">字典名称:</td><td><input class="easyui-textbox" type="text" name="name" value="${result.name}" data-options="required:true,width:250,validType:'maxLength[20]'"></input></td>
				    			<td class="title">字典编号:</td><td><input class="easyui-textbox" type="text" name="code" value="${result.code}" data-options="required:true,width:250,validType:'maxLength[20]'" ></input></td>
				    		</tr>
				    		<tr>
				    			<td class="title">字典值:</td><td><input class="easyui-textbox" type="text" name="value" value="${result.value}" data-options="required:true,width:250,validType:'maxLength[20]'"></input></td>
				    		</tr>
				    </table>
			</div>
		</form>	
</body>
