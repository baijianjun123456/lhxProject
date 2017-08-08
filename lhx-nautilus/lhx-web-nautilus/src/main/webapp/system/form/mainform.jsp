<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="/common/jsp/header.jsp"%>
<link rel="stylesheet" type="text/css" href="<%=basePath%>/common/css/common.css">

   <script type="text/javascript"	src="<%=basePath%>system/form/js/form.js" ></script>
	<body style="width:99%;">
		<div class="easyui-layout" style="width:100%;height:650px">
			<div data-options="region:'west',split:true" title="表单列表" style="width:20%">
					<div class="easyui-panel" style="padding:5px" >
						<ul class="easyui-tree" id="tableMenuList" data-options="url:'<%=basePath%>system/treeManager/ajaxJson.do?serviceName=formTypeTreeServiceImpl',method:'get',animate:true">
							<%-- <c:forEach var="formType" items="${formTypeList}" varStat<%=basePath%>
							</c:forEach> --%>
						</ul>
					</div>
			</div>
			<div data-options="region:'center'" title="表单列信息" style="width:80%">
				<iframe id="mainframe"  width="98%" height="98%" frameborder="0" scrolling="auto" >
					
				</iframe>
			</div>
		</div>
	<%@ include file="/common/jsp/page.jsp"%> 
</body>
