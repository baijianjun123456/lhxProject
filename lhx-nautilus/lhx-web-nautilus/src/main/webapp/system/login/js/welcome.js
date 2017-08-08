$(function(){
	$("#typeMenu").find("li a").each(function(i,item){
		$(item).click(function(){
			var text = $(item).html();
			var value = $(item).attr("value");
			$("#butType").html(text);
			$("#type").val(value);
		});

	});
	
	$("#search").click(function(){
		function success(data){
			var datalist = data.result;
			var html = "";
			for(var i = 0 ; i < datalist.length; i++){
				var code = datalist[i].code;
				var name = datalist[i].name;
				html = html + '<li><a href=javascript:void(0)  onClick="selectStock(\''+code+'\',\''+name+'\')">'+name+'('+code+')</a></li>';
			}
			$("#stockList").html(html);
			
			$("#downListId").click();
		}
		
		var type = $("#type").val();
		var name = $("#name").val();
		ajax.sendJsonRequest("POST",basePath+"/market/manager/search.do",{"type":type,"name":name},success,null);
		
	});
});

function stockPage(tcode,tname){
	$("#mainframe").attr("src",basePath+"market/manager/page/mainChart.do?type=main&tcode="+tcode+"&tname="+tname);
}

function selectStock(tcode,tname){
	$("#mainframe").attr("src",basePath+"market/manager/page/mainChart.do?type=main&tcode="+tcode+"&tname="+tname);
}

function getAllSelf(){
	
	function success(data){
		var datalist = data.datalist;
		var html = "";
		for(var i = 0 ; i < datalist.length; i++){
			var code = datalist[i].tcode;
			var name = datalist[i].tname;
			html = html + '<li><a href=javascript:void(0)  onClick="selectStock(\''+code+'\',\''+name+'\')">'+name+'('+code+')</a></li>';
		}
		$("#selfMenu").html(html);
		
	}
	
	ajax.sendJsonRequest("POST",basePath+"/market/manager/getAllSelf.do",null,success,null);
}
