
var myChart = echarts.init(document.getElementById('main'));

$(document.body).height($(window).height());


function success(data){
	setHeadInfo(data.series[0].data);
	var param = {
			xdata : data.xAxis[0].data,
			sdata : data.series[0].data,
			pointData  : data.pointData,
			tdstList : createTDSTdata(data.tdstList)
	};
    myChart.setOption(getOption(param));
}

function setHeadInfo(xdata){
	var lastData = xdata[xdata.length-1];
	$("#open").html("开盘价："+lastData[0]);
	$("#close").html("收盘价：："+lastData[1]);
	$("#hight").html("最高价："+lastData[3]);
	$("#low").html("最低价："+lastData[2]);
}

ajax.sendJsonRequest("POST",basePath+"market/manager/chartData.do?tcode="+$("#tcode").val(),null,success,null);

function getOption(param){
	var option = {
		    
		    tooltip : {
		        trigger: 'axis',
		        formatter: function (params) {
		            var res = params[0].seriesName + ' ' + params[0].name;
		            res += '<br/>  开盘 : ' + params[0].value[0] + '  最高 : ' + params[0].value[3];
		            res += '<br/>  收盘 : ' + params[0].value[1] + '  最低 : ' + params[0].value[2];
		            return res;
		        }
		    },

		    grid:{
		    	height:'65%',
		    	width:'98%'
		    },
		    toolbox: {
		        show : true,
		        feature : {
		            dataZoom : {show: true},
		            saveAsImage : {show: true},
				    myTool : {
		                show : true,
		                title : '全屏',
		                icon : basePath+'common/plugin/jquery-easyui/1.4.3/themes/icons/search.png',
		                onclick : function (){
		                	stockDisplay($("#tcode").val(),$("#tname").val());
		                }
				    },
		        }
		    },
		    dataZoom : {
		        show : true,
		        realtime: false,
		        start : 85,
		        end : 100,
		        zoomLock : false
		    },
		    yAxis : [
		        {
		            type : 'value',
		            scale:true,
		            axisLabel : {
	                     show:true,
	                     textStyle: {
	                         color: 'rgba(203, 203, 203, 1)'
	                     }
	                },
	                splitLine : {
	                     show:true,
	                     lineStyle: {
	                         color: '#483d8b',
	                         type: 'dashed',
	                         width: 1
	                     }
	                 },
		            boundaryGap: [0.01, 0.01]
		        }
		    ],
		    xAxis : [
		             {
		                 type : 'category',
		                 boundaryGap : true,		                      
		                 axisLabel : {
		                     show:true,
		                     textStyle: {
		                         color: 'rgba(203, 203, 203, 1)'
		                     }
		                 },
		                 splitLine : {show:false},
		                 axisTick: {onGap:false},
		                 data : param.xdata
		             }
		     ],
		     series : [
		               {
		                   name:'日K线',
		                   type:'k',
		                   data:param.sdata,
		                   markPoint : {
		                       symbolSize:0,
		                       itemStyle:{
		                      	 normal:{label:{  
		                               formatter: function (param) {  
		      	                         if (param.value == "+")  
		      	                             return '+';  
		      	                         else  
		      	                            return param.value;  
		                               }    
		                             }  
		                           }
		                      },
		                      data : param.pointData
		                   }
		               },
		               {
		                   name: 'MA5',
		                   type: 'line',
		                   data: calculateMA(5,param.sdata),
		                   smooth: true,
		                   lineStyle: {
		                       normal: {
		                    	   color:'#F7A71C',
		                           opacity: 0.5		                           
		                       }
		                   }
		               }
		               ,
		               {
		                   name: 'MA5',
		                   type: 'line',
		                   data: calculateMA(5,param.sdata),
		                   smooth: true,
		                   lineStyle: {
		                       normal: {
		                    	   color:'#F7A71C',
		                           opacity: 0.5		                           
		                       }
		                   }
		               }
		               ,
		               {
		                   name: 'MA10',
		                   type: 'line',
		                   data: calculateMA(10,param.sdata),
		                   smooth: true,
		                   lineStyle: {
		                       normal: {
		                    	   color:'#F7A71C',
		                           opacity: 0.5		                           
		                       }
		                   }
		               }
		               ,
		               /*{
		            	   name: '止损线',
		                   type: 'line',
		                   data: [],
		                   markLine: {
		                       itemStyle : {
		                           normal:{lineStyle:{type:'dashed',color:'red'},label:{show:true,position:'left'}}  //dashed,solid
		                       },
		                       symbol: ['none', 'none'],
			                   data: [
			                            [
				   	                         { xAxis: '2017/4/10', yAxis: 3100},
				   	                         {xAxis: '2017/4/11', yAxis: 3100}
			                             ],[
				   	                         { xAxis: '2017/4/11', yAxis: 3100},
				   	                         {xAxis: '2017/4/12', yAxis: 3100}
			                             ],[
				   	                         { xAxis: '2017/4/12', yAxis: 3100},
				   	                         {xAxis: '2017/4/13', yAxis: 3100}
			                             ],[
				   	                         { xAxis: '2017/4/13', yAxis: 3100},
				   	                         {xAxis: '2017/4/14', yAxis: 3100}
			                             ],[
				   	                         { xAxis: '2017/4/14', yAxis: 3100},
				   	                         {xAxis: '2017/4/17', yAxis: 3100}
			                             ]
			               		 ]
			                }
		               },*/
		               {
		            	   name: '止盈线',
		                   type: 'line',
		                   data: [],
		                   markLine: {
		                       itemStyle : {
		                           normal:{lineStyle:{type:'dashed',color:'green'},label:{show:true,position:'left'}
		                           }  //dashed,solid
		                       },
		                       symbol: ['none', 'none'],
			                   data: param.tdstList
			               }
		               }
		     ]

		};
	return option;
}

//数组处理
function splitData(rawData) {
    var datas = [];
    var times = [];
    var vols = [];
    var macds = [];
    var difs = [];
    var deas = [];
    for (var i = 0; i < rawData.length; i++) {
        datas.push(rawData[i]);
        times.push(rawData[i].splice(0, 1)[0]);
        vols.push(rawData[i][4]);
        macds.push(rawData[i][6]);
        difs.push(rawData[i][7]);
        deas.push(rawData[i][8]);
    }
    return {
        datas: datas,
        times: times,
        vols: vols,
        macds: macds,
        difs: difs,
        deas: deas
    };
}

//MA计算公式
function calculateMA(dayCount,sdata) {
    var result = [];
    for (var i = 0, len = sdata.length; i < len; i++) {
        if (i < dayCount) {
            result.push('-');
            continue;
        }
        var sum = 0;
        for (var j = 0; j < dayCount; j++) {
            sum += sdata[i - j][2];
        }
        result.push((sum / dayCount).toFixed(2));
    }
    return result;
}


/**
 * 创建止盈线；
 * @param tdstList
 * @returns {Array}
 */
function createTDSTdata(tdstList){
	var tdstArray = [];
	var index = -1;
	for(var i = 0 ; i < tdstList.length ; i++){
		var tdstData = tdstList[i];
		var xtimeValues = tdstData.xtimes.split(",");
		for(var j = 0; j < xtimeValues.length - 1; j++){
			tdstArray[++index] = [];
			var lineStart = {xAxis:xtimeValues[j],yAxis:tdstData.yValue};
			tdstArray[index][0] = lineStart;
			var lineEnd = {xAxis:xtimeValues[j+1],yAxis:tdstData.yValue};
			tdstArray[index][1] = lineEnd;
		}

	} 
	return tdstArray;
}

function addSelf(tcode,tname){
	function success(data){
		$("#addSelfId").hide();
		$("#removeSelfId").show();
	}

	ajax.sendJsonRequest("POST",basePath+"market/manager/addSelf.do",{"tcode":tcode,"tname":tname},success,null);
}

function removeSelf(tcode,tname){
	function success(data){
		$("#addSelfId").show();
		$("#removeSelfId").hide();
	}

	ajax.sendJsonRequest("POST",basePath+"market/manager/removeSelf.do",{"tcode":tcode,"tname":tname},success,null);
}

function stockDisplay(tcode,tname){
	window.open(basePath+"market/manager/page/mainChartMax.do?type=main&tcode="+tcode+"&tname="+tname);   
}
