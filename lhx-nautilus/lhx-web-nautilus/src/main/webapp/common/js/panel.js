
/**  
 * 创建新选项卡  
 * @param tabId    选项卡id  
 * @param title    选项卡标题  
 * @param url      选项卡远程调用路径 
 * @param isUpdate  如果该页签存在是否更新
 * @param onSelect:被选中时触发的函数；
 * @param onSelect:被更新时触发的函数；
 * @param onSelect:当关闭是触发的函数；
 * 
 */  
function addTab(parameter){  
	this.tabId = parameter.tabId;
	this.title = parameter.title;
	this.url = parameter.url;
	this.isUpdate = parameter.isUpdate;
	this.tabId = parameter.tabId +"_tab";
	var tabObj = $('#contentTabs');
	if(isUpdate && tabObj.tabs('exists', parameter.title)){
		tabObj.tabs('select', parameter.title);
	}
	else{
        var name = 'iframe_'+parameter.tabId;  
        tabObj.tabs('add',{  
            title: parameter.title,           
            closable:true,  
            cache : false,  
            content : '<iframe name="'+name+'"id="'+parameter.tabId+'"src="'+parameter.url+'" width="98%" height="98%" frameborder="0" scrolling="auto" ></iframe>' 
        }); 
	};
 
}  

/**
 * 刷新当前页签页
 * @param tbsId
 * @param title
 */
function refreshCurrentTab(){  
	var currentTab = $('#contentTabs').tabs('getSelected');
	refreshTab(currentTab);
}  

/**
 * 刷新指定tab
 * @param title
 */
function refreshAnyTab(title){
	var currentTab = $('#contentTabs').tabs('getTab' , title);
	$('#contentTabs').tabs('select', title);
	refreshTab(currentTab);
}

function refreshTab(currentTab){
	var content = $(currentTab.panel('options')).attr('content');
    $('#contentTabs').tabs('update', {
          tab: currentTab,
          options: {
        	  content:content 
          }
      });
}


/**
 * 关闭页签签页
 * @param tbsId
 * @param title
 */
function closeTab(){
	var currentTab = $('#contentTabs').tabs('getSelected');
	var index = $('#contentTabs').tabs('getTabIndex',currentTab);
	$('#contentTabs').tabs('close',index);
} 

function Dialog(parameter){
	
	this.title = parameter.title;
	
	this.width = parameter.width;
	
	this.height = parameter.height;
	
	this.href = parameter.href;
	
	
	/**
	 * 创建Dialog
	 */
	this.create = function(){
		var dilogDiv = $("<DIV option=''></DIV>");
			dilogDiv.dialog({
		    title: this.title,
		    width: this.width,
		    height: this.height,
		    closed: false,
		    cache: false,
		    href: this.href,
		    modal: true,
		    onClose:function(){  
                $(this).dialog('destroy');  
            },

		    buttons:[     
	                  {  
				           text:'提交',  
				           iconCls:'icon-add',  
				           handler:function(){ 
		        	   			if(typeof parameter.save != 'undefined'){
		        	   				parameter.save();
		        	   				dilogDiv.dialog('destroy');
		        	   			}  
	           				}  
	      		        },
	      		        {  
	      		        	text:'关闭',  
					        iconCls:'icon-cancel',  
				           	handler:function(){
				           		if(typeof parameter.close != 'undefined'){
		        	   				parameter.close();
		        	   			}  
				           		dilogDiv.dialog('destroy');
				           	 }  
	      		        }
		      		 ]  
		
		});
	};
	
	/**
	 * 刷新Dialog
	 */
	this.refresh = function(){
		$('#'+this.id).dialog('refresh', this.href );
	};

}
