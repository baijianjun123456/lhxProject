<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="/common/jsp/header.jsp"%>
<link rel="stylesheet" type="text/css" href="<%=basePath%>/common/css/common.css">

<script type="text/javascript"	src="<%=basePath%>system/form/js/form.js" ></script>
<body style="width:99%;">
    	<form id="formSearchForm"  action="<%=basePath%>system/formManager/list.do"">
    		<input type="hidden" id="tableName" name="tableName" value="${tableName}" />
		</form>	
	
		<table  id="formList" title="表单列表" data-options="rownumbers:true,singleSelect:true,iconCls:'icon-ok'" style="height:250px"   dataurl="<%=basePath%>system/formManager/ajaxlist.do" >
		</table>
		
		<div id="addFormFiled"></div>
	<%@ include file="/common/jsp/page.jsp"%> 
</body>
