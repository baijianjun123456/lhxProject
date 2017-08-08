<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="/common/jsp/header.jsp"%>
<link rel="stylesheet" type="text/css" href="<%=basePath%>/common/css/welcome.css">
<script type="text/javascript"	src="<%=basePath%>common/js/panel.js" ></script>
<script type="text/javascript"	src="<%=basePath%>system/login/js/welcome2.js" ></script>

</head>  

<body style="width:99%;height:890px;">

	<div id="cc" class="easyui-layout" style="width:100%;height:100%;">
		<div data-options="region:'north'" style="height:15%">
			
			<div style="height:73%;"></div>
			<div style="height:25%;text-align:right;padding-right:10px;">
				<spna>欢迎登陆！${USER_INFO.user.name} </spna><a class="easyui-linkbutton c6 l-btn l-btn-small"  id="loginOut" name = "loginOut"  >退出</a>
			</div>
		</div>
		<div data-options="region:'west',split:true" title="菜单栏" style="width:15%;height:100%">
				<div class="easyui-accordion" data-options="multiple:true" style="width:100%;height1:300px;">
					<div title="会员管理" data-options="iconCls:'icon-ok'" style="overflow:auto;" >
						<div class="menusub" id="system_01" title="注册会员"  url="<%=basePath%>system/userManager/page/userList.do?type=list">注册会员</div>
						
					</div>
					<div title="行情数据管理" >
						<div class="menusub"  id="hqsjgl_01" title="行情数据管理">行情数据管理</div>
					</div>
					<div title="行情信息显示" >
						<div class="menusub"  id="hqxxxs_01" title="行情信息显示" url="<%=basePath%>market/manager/page/mainChart.do">行情信息显示</div>
					</div>
					<div title="自选股" >
						<div class="menusub"  id="zxg_01" title="自选股">自选股</div>
					</div>
					<div title="收藏夹">
						<div class="menusub"  id="scj_01" title="收藏夹">收藏夹</div>
					</div>
					<div title="微信订阅号">
						<div class="menusub"  id="wxdyh_01" title="微信订阅号">微信订阅号</div>
					</div>
					<div title="系统管理">
						<div class="menusub" id="system_01" title="角色管理"  url="<%=basePath%>system/roleManager/page/roleList.do?type=list">角色管理</div>
						<%--<div class="menusub" id="system_02" title="菜单管理"  url="<%=basePath%>system/menuManager/page/menuList.do?type=list">菜单管理</div> --%>
						<div class="menusub" id="system_02" title="菜单管理"  url="<%=basePath%>system/menuManager/page/menuMain.do?isMain=main">菜单管理</div>
						<%--<div class="menusub" id="system_03" title="权限管理"  url="<%=basePath%>system/resourceManager/page/resourceList.do?type=list">权限管理</div> --%>
						<div class="menusub" id="system_03" title="权限管理"  url="<%=basePath%>system/resourceManager/page/resourceMain.do?isMain=main">权限管理</div>
						<div class="menusub" id="system_04" title="数据字典"  url="<%=basePath%>system/dictManager/page/dictMain.do?isMain=main">数据字典</div>
					</div>
					<div title="表单管理">
						<div class="menusub" id="bdgl_01" title="表单分类"  url="<%=basePath%>system/formTypeManager/page/formTypeList.do?type=list">表单分类</div>
						<div class="menusub" id="bdgl_02" title="表单定义"  url="<%=basePath%>system/formDefManager/page/formDefMain.do?isMain=main">表单定义</div>
						<div class="menusub" id="bdgl_03" title="表单字段管理"  url="<%=basePath%>system/formManager/page/mainform.do?isMain=main">表单字段管理</div>
					</div>
					<div title="公告管理">
						<div class="menusub" id="bdgl_01" title="表单分类"  url="<%=basePath%>/message/publicize/page/publicizeList.do?type=list">公告列表</div>					
					</div>
				</div>
		</div>
		<div data-options="region:'center'"  title = "内容" style="width:80%;height:95%" >
			   <div class="easyui-tabs" id="contentTabs" fit="true" border="false">  
		            <div title="欢迎页" style="padding:20px;overflow:hidden;">   
		                <div style="margin-top:20px;">  
		                    <h3>你好，欢迎来到鹦鹉螺</h3>  
		                </div>  
		            </div>  
		        </div>  
		 </div>
	
	</div>
</body>
</html>
