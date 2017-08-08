<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="/common/jsp/header.jsp"%>
<link rel="stylesheet" type="text/css" href="<%=basePath%>/common/css/common.css">

<script type="text/javascript"	src="<%=basePath%>system/role/js/role.js" ></script>
<body style="width:99%;">
		<input type="hidden" id="type" value="${type}"/>
    	<form id="roleSearchForm"  action="<%=basePath%>system/roleManager/list.do"">
			<div class="easyui-accordion " data-options="multiple:true" style="width:100%;height1:300px;" id="searchq">
					<div title="查询条件" data-options="iconCls:'icon-ok'" style="overflow:auto;padding:10px;">
						<table class="searchTab" style="width:100%">

							<tr>
								<td class='title'>角色名称:</td><td><input isSearch='istrue' class='easyui-textbox content' type='text' name=name value='${result.name}'></input></td>
							
								<td  style='text-align:left;' >
									<a class='easyui-linkbutton buttonq' iconCls='icon-search' id='submitid'>查询</a>
								</td>
							</tr>
					    </table>
					</div>
			</div>
		</form>	
	
		<table  id="roleList" title="角色管理列表" data-options="rownumbers:true,singleSelect:true,iconCls:'icon-ok'" style="height:250px"   dataurl="<%=basePath%>system/roleManager/ajaxlist.do" >
		</table>
	<%@ include file="/common/jsp/page.jsp"%> 
</body>
