var countData = 16;


function Page(gridId,tilte,columns,buttons,url,searchFormId,pageSize){
		
	var graid = $('#'+gridId);
	
	if(!pageSize){
		pageSize = 15;
	}
	
	var selectBttons = createButtons(buttons);
	graid.datagrid({
        title: tilte,  //表格名称
        iconCls: 'icon-edit',  //图标
        //width:480,   //表格宽度
        height:'auto',   //表格高度，可指定高度，可自动
        border:true,  //表格是否显示边框
        url:url,   //获取表格数据时请求的地址
        columns:columns,
        pagination:true,//如果表格需要支持分页，必须设置该选项为true
        pageSize:pageSize,   //表格中每页显示的行数
        pageList:[10,15,20,25,30],
        rownumbers:true,   //是否显示行号
        nowrap: false,   
        striped: true,  //奇偶行是否使用不同的颜色
        method:'post',   //表格数据获取方式,请求地址是上面定义的url
        idField: 'id_',
        loadMsg:'数据正在努力加载，请稍后...',   //加载数据时显示提示信息
        frozenColumns: [[  //固定在表格左侧的栏
                    {field: 'id_', checkbox: true},
                  ]],
        toolbar: selectBttons,
	    onBeforeLoad:function(param){
	    	 param.pageNo = param.page;
	    	 param.pageSize = param.rows;
	    	 creatParam(param);
	    	 delete param["rows"];
	      }
      });
	
	/**
	 * 创建工具栏按钮；
	 */
	function createButtons(buttons){
		var toolbar = [];
		var buttonIdList = buttons.split(",");
		var index = 0;
		for(var i in buttonIdList){
			
			var buttonDef = buttonAllMap[buttonIdList[i]];
			if(buttonDef){
				toolbar[index++] = buttonAllMap[buttonIdList[i]];
			}
		}
		return toolbar;
	}
	
	/**
	 *创建查询参数；
	 */
	function creatParam(param){
		if(param == null){
			param = {};
		} 
		$("#"+searchFormId).find("input[class='textbox-value'],select[class='textbox-value'],radio[class='textbox-value'],checkbox[class='textbox-value']").each(function(i,item){
		
			var attrName = $(item).attr("name");
			var attrValue = $(item).val();
			param[attrName] = attrValue;

		});
		
		$("#"+searchFormId).find("input[type='hidden']").each(function(i,item){
			
			var attrName = $(item).attr("name");
			var attrValue = $(item).val();
			param[attrName] = attrValue;

		});
	};
	
   //搜索查询；
   this.doSearch=function() {
	   graid.datagrid("load", null);
    };
    
    /**
     * 获取选中行；
     * isSingle=true:得第一个选中行数据，如果没有选中行，则返回 null，否则返回记录。
     * isSingle=false:取得所有选中行数据，返回元素记录的数组数据
     */
    this.getSelectRows=function(isSingle){
    	var rows = null;
    	if(!isSingle){
    		rows = graid.datagrid('getSelections');
    	}
    	else{
    		rows = graid.datagrid('getSelected');
    	}
    	return rows;
    };
}

