<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="/common/jsp/header.jsp"%>
<link rel="stylesheet" type="text/css" href="<%=basePath%>/common/css/common.css">
 <meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
<script type="text/javascript"	src="<%=basePath%>message/publicize/js/publicize.js" ></script>
<!-- 配置文件 -->  
<script type="text/javascript" src="<%=basePath%>common/ueditor/ueditor.config.js"></script>  
 <script type="text/javascript" charset="utf-8" src="<%=basePath%>common/ueditor/_examples/editor_api.js"></script>
<body style="width:99%;">
		<input type="hidden" id="type" value="${type}"/>

    	<form id="addPublicizeForm"  action="<%=basePath%>message/publicize/addPublicize.do"">
			<div class="easyui-accordion " data-options="multiple:true" style="width:100%;height:650px;" id="addForm">
					<%-- <input type="hidden" name = "orgId" value="${result.orgId==null?'000000000000':result.orgId}" />
					<input type="hidden" name = "orgIdenty" value="${result.orgIdenty==null?'10000':result.orgIdenty}" />
					<input type="hidden" name = "orgLevel" value="${result.orgLevel==null?'10000':result.orgLevel}" /> --%>
					<input type="hidden" name = "id_" id="id_" value="${result.id_}" />					
					<div title="公告信息" data-options="iconCls:'icon-ok'" style="overflow:auto;padding:10px;">
						<table class="addTab" style="width:100%">
					    		<tr>
					    			<td class="title">公告名称:</td><td colspan="3"><input class="easyui-textbox" type="text" name="title" id="title" value="${result.title}" data-options="required:true,width:800"></input></td>
					    			<%-- <td class="title">接收人:</td><td><input class="easyui-textbox" type="text" name="member" id="member" value="${result.member}" data-options="required:true,width:250" validType="checkIsExist"></input></td> --%>
					    			
					    		</tr>	
					    		<tr>	
					    			<td class="title">摘要:</td><td><input class="easyui-textbox" type="text"  name="abstrac" id="abstrac" value="${result.abstrac}" data-options="width:800,required:true,validType:'mobile'"></input></td>
					    		</tr>			    		
					    		<tr>				    							    			
					    			<td class="title">级别：</td>		    			
					    			<td colspan="3">	
					    				  <input id="roleid" name="roleid"  style="width: 800px;"  class="easyui-combobox" >  
									</td>
					    		</tr>
					    			<%-- <td class="title">摘要:</td><td><input class="easyui-textbox" type="text"  name="abstrac" id="abstrac" value="${result.abstrac}" data-options="width:250,required:true,validType:'mobile'"></input></td> --%>
					    			<!-- <td class="title">级别：</td>		    			
					    			<td>	
					    				<select class="easyui-combobox" name="level" data-options="width:250">  					  			
											<option value="1" selected>一级</option>
											<option value="2" >二级</option>
											<option value="3">三级</option>
											<option value="4">四级</option>
											<option value="5">五级</option>
											<option value="6">六级</option>
											<option value="7">七级</option>
											<option value="8">八级</option>
											<option value="9">九级</option>
											<option value="10">十级</option>										
										</select>
									</td>	 -->	
					    		<tr>
					    			<div>
					    				<%--  <script id="editor" type="text/plain" id="content" name="content" value="${result.content}" ></script>	 --%>
					    				<c:if test="${type ne 'add'}" >
					    				   <textarea id="content" name="content" >${result.content}</textarea>	
					    				 </c:if>
					    				 <c:if test="${type eq 'add'}" >
					    				   <textarea id="content" name="content" style="width:100%;height:400px;"></textarea>	
					    				 </c:if>
					    			</div>
					    			
					    		</tr>
					    		<tr>
						    		<td colspan="10" style="text-align:center;" >
						    			<a class="easyui-linkbutton buttonq" iconCls="icon-save" id="savePublicize">发送</a>
						    			<c:if test="${type eq 'add'}" >
						    				<a class="easyui-linkbutton buttonq" iconCls="icon-reload" id="clearUser">清空</a>
						    			</c:if>
						    		</td>
					    		</tr>
					    </table>
					</div>
			</div>
		</form>	
		<script type="text/javascript">
	    //实例化编辑器
	    //建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例	   
	    $(function(){  	 
	    	 var ue = UE.getEditor('content');
	    	
	    	 //初始化多选复选框  
	    	 initCombobox('roleid','XSRY_CD');//学术荣誉的字典编码是XSRY_CD  
	    	
	    });  
	    //参数：id  控件id   code 字典编码  
	    function initCombobox(id,code){  	    	
	    	            var value = "";  
	    	            //加载下拉框复选框  
	    	            $('#'+id).combobox({  
	    	                url:basePath+'message/publicize/getComboboxData', //后台获取下拉框数据的url  
	    	                method:'post',  
	    	                panelHeight:200,//设置为固定高度，combobox出现竖直滚动条  
	    	                valueField:'id__',  
	    	                textField:'name_',  
	    	                multiple:true,  
	    	                formatter: function (row) { //formatter方法就是实现了在每个下拉选项前面增加checkbox框的方法  
	    	                    var opts = $(this).combobox('options');  	    	                	
	    	                    return '<input type="checkbox" class="combobox-checkbox">' + row[opts.textField]  
	    	                },  
	    	                onLoadSuccess: function () {  //下拉框数据加载成功调用  	
	    	                   /*  var opts = $(this).combobox('options'); 
	    	                    var target = this;  
	    	                    var values = $(target).combobox('getValues');//获取选中的值的values 
	    	                    alert(values);
	    	                    $.map(values, function (value) {  
	    	                        var el = opts.finder.getEl(target, 5);
	    	                        el.find('input.combobox-checkbox')._propAttr('checked', true);   
	    	                    })   */	    	                    
	    	                    var selectRoleId="${resultRERecord.roleid}";	    	                    
	    	                    var selectRoleIdArr = selectRoleId.split(",");
	    	                    for (var r = 0; r < selectRoleIdArr.length; r++) {	
	    	                    	if(""!=selectRoleIdArr[r]&&null!=selectRoleIdArr[r]){
	    	                    		$('#roleid').combobox('select',selectRoleIdArr[r]);//菜单项可以text或者id
	    	                    	}	    	                    	
								}	    	                    
	    	                   
	    	                },  
	    	                onSelect: function (row) { //选中一个选项时调用  
	    	                    var opts = $(this).combobox('options');  
	    	                    //获取选中的值的values  
	    	                    $("#"+id).val($(this).combobox('getValues'));  	    	                     
	    	                   //设置选中值所对应的复选框为选中状态  
	    	                    var el = opts.finder.getEl(this, row[opts.valueField]);  
	    	                    el.find('input.combobox-checkbox')._propAttr('checked', true);  	    	                 
	    	                },  
	    	                onUnselect: function (row) {//不选中一个选项时调用  
	    	                    var opts = $(this).combobox('options');  
	    	                    //获取选中的值的values  
	    	                    $("#"+id).val($(this).combobox('getValues'));  	    	                    
	    	                    var el = opts.finder.getEl(this, row[opts.valueField]);  
	    	                    el.find('input.combobox-checkbox')._propAttr('checked', false);  
	    	                }  
	    	            });  
	    }  
	    //function getContent() {
	      //  var arr = [];
	        /* arr.push("使用editor.getContent()方法可以获得编辑器的内容");
	        arr.push("内容为："); */
	        //arr.push(UE.getEditor('editor').getContent());
	        //alert(arr.join("\n"));
	        //alert(UE.getEditor('editor').getContent());
	    //}
</script>
</body>