<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="/common/jsp/header.jsp"%>
<link rel="stylesheet" type="text/css" href="<%=basePath%>/common/css/common.css">

   <script type="text/javascript"	src="<%=basePath%>system/resource/js/resource.js" ></script>
	<body style="width:99%;">
		<div class="easyui-layout" style="width:22%;height:650px">
			<div data-options="region:'west',split:true" title="菜单" style="width:100%">
					<div class="easyui-panel" style="padding:5px" >
					    <div style="margin:10px">
							<input class="easyui-searchbox" data-options="prompt:'请输入菜单名称检索'" style="width:95%"></input>
						</div>
						<ul class="easyui-tree" id="resourceTreeList" data-options="url:'<%=basePath%>system/treeManager/ajaxJson.do?serviceName=menuTreeServiceImpl',method:'get',animate:true,'onLoadSuccess':treeLoadSucess,'state':'closed'">

						</ul>
					</div>
			</div>

			<div data-options="region:'center'" title="资源列表" style="width:87%">
				<iframe id="mainframe"  width="98%" height="98%" frameborder="0" scrolling="auto" >
					
				</iframe>
			</div>
		</div>
	<%@ include file="/common/jsp/page.jsp"%> 
</body>
