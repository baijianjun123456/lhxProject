<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="/common/jsp/header.jsp"%>
<link rel="stylesheet" type="text/css" href="<%=basePath%>/common/css/welcome.css">
</head>  
<body>
	<form action="">
		<div class="login">
			<div><lable><s:message code="login.userName" /></lable><sapn><input type="text"  name="userName"/></sapn></div>
			<div><lable ><s:message code="login.password" /></lable><sapn><input type="text"  name="password"/></sapn></div>
			<div><lable><s:message code="login.code" /></lable><sapn><input type="text"  name="code" id="code"/></sapn><sapn><img id="codeImg" name = "codeImg" src="" /></sapn></div>
		 </div>
	 </form>
</body>
</html>
