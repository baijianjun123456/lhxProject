<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="/common/jsp/header.jsp"%>
<link rel="stylesheet" type="text/css" href="<%=basePath%>/common/css/common.css">

<script type="text/javascript"	src="<%=basePath%>system/dict/js/dict.js" ></script>
<body style="width:99%;">
		<input type="hidden" id="type" value="${type}"/>
    	<form id="dictSearchForm"  action="<%=basePath%>system/dictManager/list.do">
    		<input type="hidden" id="pcode" name="pcode" value="${pcode}"/>
			<div class="easyui-accordion " data-options="multiple:true" style="width:100%;height1:300px;" id="searchq">
					<div title="查询条件" data-options="iconCls:'icon-ok'" style="overflow:auto;padding:10px;">
						<table class="searchTab" style="width:100%">
							<tr>
								<td class='title'>名称:</td><td><input isSearch='istrue' class='easyui-textbox content' type='text' name=name value='${result.name}'></input></td>
								<td class='title'>编码:</td><td><input isSearch='istrue' class='easyui-textbox content' type='text' name=code value='${result.code}'></input></td>
								<td colspan='10' style='text-align:center;' >
									<a class='easyui-linkbutton buttonq' iconCls='icon-search' id='submitid'>查询</a>
									<a class='easyui-linkbutton buttonq' iconCls='icon-reload'>重置</a>
								</td>
							</tr>
					    </table>
					</div>
			</div>
		</form>	
	
		<table  id="dictList" title="数据字典列表" data-options="rownumbers:true,singleSelect:true,iconCls:'icon-ok'" style="height:250px"   dataurl="<%=basePath%>system/dictManager/ajaxlist.do" >
		</table>
	<%@ include file="/common/jsp/page.jsp"%> 
</body>
