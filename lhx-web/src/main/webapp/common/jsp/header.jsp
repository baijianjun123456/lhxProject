<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" lang="en-US"><head>
<meta http-equiv="X-UA-Compatible" content="edge" />
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8"> 
<script type="text/javascript">
	var basePath = "<%=basePath%>";
</script>
<script type="text/javascript"	src="<%=basePath%>common/plugin/jquery/3.2.1/jquery-3.2.1.min.js" ></script>
<script type="text/javascript"	src="<%=basePath%>common/plugin/jquery-easyui/1.4.3/jquery.easyui.min.js" ></script>
