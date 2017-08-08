$(function(){
	$("#loginOut").click(function(){
		window.location.href=basePath+"loginOut";
	});
	
	$('#contentTabs').tabs({onSelect:function(title,index){
		var tabPanle = $('#contentTabs').tabs('getTab',title);
		
		if(tabPanle.find('iframe').length > 0){
			var contentWindow = tabPanle.find('iframe')[0].contentWindow;
			if(typeof contentWindow.tabOnSelect != "undefined"){
				contentWindow.tabOnSelect(tabPanle);
			}	
		}
		else{
			if(typeof tabPanle.tabOnSelect != "undefined"){
				tabPanle.tabOnSelect(tabPanle);
			}
		}
		    
	}});

	$('#contentTabs').tabs({onUpdate:function(title,index){
		var tabPanle = $('#contentTabs').tabs('getTab',title);
		var contentWindow = tabPanle.find('iframe')[0].contentWindow;
		if(typeof contentWindow.tabOnUpdate != "undefined"){
			contentWindow.tabOnUpdate(tabPanle);
		}	
	}});
  
	$('#contentTabs').tabs({onBeforeClose:function(title,index){
		var tabPanle = $('#contentTabs').tabs('getTab',title);
		var contentWindow = tabPanle.find('iframe')[0].contentWindow;
		if(typeof contentWindow.tabonClose != "undefined"){
			contentWindow.tabonClose(tabPanle);
		}	
	}});
	
	$("div[class='menusub']").click(function(i,item){
		var addTabParam = {
				"tabId":     $(this).attr("id"),
				"title":     $(this).attr("title"),
				  "url":     $(this).attr("url"),
			 "isUpdate":      true
		};
		
		addTab(addTabParam);
	});
});


