<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="/common/jsp/header.jsp"%>
<html style="background-color:rgba(246, 246, 246, 1);">
	<link rel="shortcut icon" href="<%=basePath%>/ico/favicon.png">
	
	<link href="<%=basePath%>common/plugin/echarts/2.2.7/css/font-awesome.min.css" rel="stylesheet">
	<link href="<%=basePath%>common/plugin/echarts/2.2.7/css/bootstrap.css" rel="stylesheet">
	<link href="<%=basePath%>common/plugin/echarts/2.2.7/css/carousel.css" rel="stylesheet">
	<link href="<%=basePath%>common/plugin/echarts/2.2.7/css/echartsHome.css" rel="stylesheet">
	<link href="<%=basePath%>common/plugin/echarts/2.2.7/css/codemirror.css" rel="stylesheet">
	<link href="<%=basePath%>common/plugin/echarts/2.2.7/css/monokai.css" rel="stylesheet">
	
	<link rel="stylesheet" type="text/css" href="<%=basePath%>common/ywl/css/custom.css">

	<body style="width:100%;padding-top:0px;height:100%;">
	  <div class="container-fluid">
	        <div class="row-fluid example">
				<input id="tcode" type="hidden" value="${tcode}" />
				<input id="tname" type="hidden" value="${tname}" />
				
				<div class="row info-cus">
		  			<h4>
		  				${tname}<small>${tcode}</small>
		  				<a class="btn btn-primary" href="javascript:void(0)" role="button"  onClick="addSelf('${tcode}','${tname}')" id="addSelfId" <c:if test="${isSelf eq 'true'}">style="display:none;" </c:if> >+  自选</a>
		  				<a class="btn btn-primary" href="javascript:void(0)" role="button" onClick="removeSelf('${tcode}','${tname}')"  id="removeSelfId" <c:if test="${isSelf ne 'true'}">style="display:none;background:#428bca;" </c:if> <c:if test="${isSelf eq 'true'}">style="background:#428bca;" </c:if>>- 取消</a>
		  			</h4>
		  				<span id="open">开盘价：46.78</span>
					    <span id="hight">最高价：48.9</span>
					    <span id="close">收盘价：41.00 </span>
		        		<span id="low">最低价：39.82</span>
		 		</div>
		 		
			   <div class="row">
			   		<ul class="nav nav-pills pill-cus">
					  <li role="presentation" class="active"><a href="#">日线</a></li>
					</ul>
			   </div>
			  
	            <div id="graphic" class="col-md-8" style="width:100%">
	                <div id="main" class="main" style="width:100%;height100%;"></div>
	            </div>
	           
	        </div>
	    </div>
		<script src="<%=basePath%>common/plugin/echarts/2.2.7/js/echarts-all-src.js"></script>
		<script src="<%=basePath%>market/display/js/mainChart.js"></script>
	 </body>
</html>