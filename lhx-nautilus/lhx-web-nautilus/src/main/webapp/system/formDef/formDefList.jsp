<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="/common/jsp/header.jsp"%>
<link rel="stylesheet" type="text/css" href="<%=basePath%>/common/css/common.css">

<script type="text/javascript"	src="<%=basePath%>system/formDef/js/formDef.js" ></script>
<body style="width:99%;">
    	<form id="formDefSearchForm"  action="<%=basePath%>system/formDefManager/list.do"">
    	    <input type="hidden" id="formType" name="formType" value="${formType}" />
    	    <input type="hidden" id="type" value="${type}"/>
			<div class="easyui-accordion " data-options="multiple:true" style="width:100%;height1:300px;" id="searchq">
					<div title="查询条件" data-options="iconCls:'icon-ok'" style="overflow:auto;padding:10px;">
						<table class="searchTab" style="width:100%">

							<tr>
								<td class='title'>表单名称:</td><td><input isSearch='istrue' class='easyui-textbox content' type='text' name=formName value='${result.formName}'></input></td>
								<td class='title'>表单编码:</td><td><input isSearch='istrue' class='easyui-textbox content' type='text' name=formCode value='${result.formCode}'></input></td>
								<td colspan='10' style='text-align:center;' >
										<a class='easyui-linkbutton buttonq' iconCls='icon-search' id='submitid'>查询</a>
										<a class='easyui-linkbutton buttonq' iconCls='icon-reload'>重置</a>
								</td>
							</tr>
					    </table>
					</div>
			</div>
		</form>	
	
		<table  id="formDefList" title="表单定义列表" data-options="rownumbers:true,singleSelect:true,iconCls:'icon-ok'" style="width:100%;height:250px"   dataurl="<%=basePath%>system/formDefManager/ajaxlist.do" >
		</table>
				
	<%@ include file="/common/jsp/page.jsp"%> 
</body>
