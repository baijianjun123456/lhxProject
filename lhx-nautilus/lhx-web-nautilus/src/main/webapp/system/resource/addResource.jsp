<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="/common/jsp/header.jsp"%>
<link rel="stylesheet" type="text/css" href="<%=basePath%>/common/css/common.css">

<script type="text/javascript"	src="<%=basePath%>system/resource/js/resource.js" ></script>
<body style="width:99%;">
		<input type="hidden" id="type" value="${type}"/>
    	<form id="addResourceForm"  action="<%=basePath%>system/resourceManager/addResource.do"">
    	    <input type="hidden" id="menuId" name="menuId" value="${menuId}"/>
    	    <input type="hidden" id="status" name="status" value="1"/>
			<div class="easyui-accordion " data-options="multiple:true" style="width:100%;height1:400px;" id="addForm">
					<input type="hidden" name = "id_" id="id_" value="${result.id_}" />
					
					<div title="系统资源访问表信息" data-options="iconCls:'icon-ok'" style="overflow:auto;padding:10px;">
						<table class="addTab" style="width:100%">
					    		<tr>
					    			<td class="title">资源名称:</td><td><input class="easyui-textbox" type="text" name="name" value="${result.name}" data-options="required:true,width:250"></input></td>
					    			<td class="title">资源UR:</td><td><input class="easyui-textbox" type="text" name="url" value="${result.url}" data-options="required:true,width:250" validType="checkIsExist"></input></td>
					    			
					    		</tr>
					    		<%-- <tr>
						    		<td colspan="10" style="text-align:center;" >
						    			<a class="easyui-linkbutton buttonq" iconCls="icon-save" id="saveResource">提交</a>
						    			<c:if test="${type eq 'add'}" >
						    				<a class="easyui-linkbutton buttonq" iconCls="icon-reload" id="clearResource">清空</a>
						    			</c:if>
						    		</td>
					    		</tr> --%>
					    </table>
					</div>
			</div>
		</form>	
</body>
