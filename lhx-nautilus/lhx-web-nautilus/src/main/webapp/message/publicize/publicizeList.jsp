<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="/common/jsp/header.jsp"%>
<link rel="stylesheet" type="text/css" href="<%=basePath%>/common/css/common.css">

<script type="text/javascript"	src="<%=basePath%>message/publicize/js/publicize.js" ></script>
<body style="width:99%;">
		<input type="hidden" id="type" value="${type}"/>		
    	<form id="publicizeSearchForm"  action="<%=basePath%>message/publicize/list.do"">
			<div class="easyui-accordion " data-options="multiple:true" style="width:100%;height1:300px;" id="searchq">
			
					<div title="查询条件" data-options="iconCls:'icon-ok'" style="overflow:auto;padding:10px;">
						<table class="searchTab" style="width:100%">
					    		<tr>					    			
					    			<td class="title">公告名:</td><td><input isSearch="istrue" class="easyui-textbox content" type="text" name="name" value="${result.title}"></input></td>
					    			<td class="title">发送人:</td><td><input isSearch="istrue" class="easyui-textbox content" type="text" name="accounts" value="${result.member}"></input></td>
					    			<td class="title">简介:</td><td><input isSearch="istrue" class="easyui-textbox content"  type="text" name="email" value="${result.abstrac}"></input></td>
					    			<td class="title">公告级别:</td><td><input isSearch="istrue" class="easyui-textbox " type="text"  name="mobile" value="${result.level}"></input></td>
					    			<td class="title">状态:</td>
					    			<td>	
					    				<select class="easyui-combobox" name="status" style="width:200px;">  
					    					<option value="">全部</option>			
											<option value="0">删除</option>
											<option value="1">正常</option>											
										</select>
									</td>
					    		</tr>
					    		<tr>
						    		<td colspan="10" style="text-align:center;"  >
						    			<a class="easyui-linkbutton buttonq" iconCls="icon-search" id="submitid">查询</a>
						    			<a class="easyui-linkbutton buttonq" iconCls="icon-reload">重置</a>
						    		</td>
					    		</tr>
					    </table>
					</div>
			</div>
		</form>		
		<table  id="publicizeList" title="公告列表" data-options="rownumbers:true,singleSelect:true,iconCls:'icon-ok'" style="height:250px"   dataurl="<%=basePath%>message/publicize/ajaxlist.do" >		
		</table>
	<%@ include file="/common/jsp/page.jsp"%> 
</body>