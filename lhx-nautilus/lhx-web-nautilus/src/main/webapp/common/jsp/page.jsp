<%@ page language="java" pageEncoding="UTF-8" %>
<script type="text/javascript"	src="<%=request.getContextPath()%>/common/js/page.js" ></script>
</head>  
<body>
	<input name="pageSize" id="pageSize" value="${result.pageSize}" type="hidden"/>
	<input name="pageNo" id="pageNo" value="${result.pageNo}" type="hidden"/>
	<input name="totalNum" id="totalNum" value="${result.total}" type="hidden"/>
	<!-- <div id="pagePanel" style="background:#F4F4F4">
		
	</div> -->
</body>
</html>
