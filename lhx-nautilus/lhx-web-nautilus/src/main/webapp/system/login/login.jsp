<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="/common/jsp/header.jsp"%>
<link rel="stylesheet" type="text/css" href="<%=basePath%>/common/css/welcome.css">

<script type="text/javascript"	src="<%=basePath%>system/login/js/login.js" ></script>

</head>  
<body>
	<form  name="loginForm" id="loginForm">
		<div class="login">
			<div><lable><s:message code="login.userName" /></lable><sapn><input type="text"  name="userName" class="easyui-validatebox textbox" data-options="required:true"/></sapn></div>
			<div><lable ><s:message code="login.password" /></lable><sapn><input type="text"  name="password" class="easyui-validatebox textbox" data-options="required:true"/></sapn></div>
			<div><lable><s:message code="login.code" /></lable><lable class="codeImg"><img id="codeImg" name = "codeImg" src=""  /></lable><lable class="codeV"><input type="text"  name="userCode" id="userCode" class="easyui-validatebox textbox" data-options="required:true"/></lable></div>
			<div><lable></lable><span><a type="button" id="loginsubmit" name = "loginsubmit"  class="easyui-linkbutton c6 l-btn l-btn-small"  >提交</a></span> </div>
		 </div>
	 </form>
</body>
</html>
