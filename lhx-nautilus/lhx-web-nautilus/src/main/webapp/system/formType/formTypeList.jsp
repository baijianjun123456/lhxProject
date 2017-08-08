<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="/common/jsp/header.jsp"%>
<link rel="stylesheet" type="text/css" href="<%=basePath%>/common/css/common.css">

<script type="text/javascript"	src="<%=basePath%>system/formType/js/formType.js" ></script>
<body style="width:99%;">
        <input type="hidden" id="type" value="${type}"/>
    	<form id="formTypeSearchForm"  action="<%=basePath%>system/formTypeManager/list.do"">
		</form>	
	
		<table  id="formTypeList" title="表单分类列表" data-options="rownumbers:true,singleSelect:true,iconCls:'icon-ok'" style="height:250px"   dataurl="<%=basePath%>system/formTypeManager/ajaxlist.do" >
		</table>
	<%@ include file="/common/jsp/page.jsp"%> 
</body>
