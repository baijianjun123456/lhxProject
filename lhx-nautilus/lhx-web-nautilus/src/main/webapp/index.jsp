<html>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<script type="text/javascript">
	//window.location.href="<%=basePath%>system/login/login.do";
	
	window.location.href="<%=basePath%>system/login/welcome.do";
</script>
<body>
	
</body>
</html>
