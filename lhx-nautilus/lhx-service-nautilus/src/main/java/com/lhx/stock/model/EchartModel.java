package com.lhx.stock.model;

import java.util.List;
import java.util.Map;
import com.lhx.stock.tdIndex.model.PointData;

public class EchartModel {
	
	private Series[] series = new Series[1];
	
	private XAxis[] xAxis = new XAxis[1];
	
	//ST,CD计数信息
	private List<PointData> pointData = null;
	
	//止盈线
	private List<Map<String,String>>  tdstList = null;

	//止损线
	private List<Map<String,String>>  stopList = null;

	public EchartModel(Series series){
		this.series[0] = series;
	}

	public EchartModel(XAxis xAxis){
		this.xAxis[0] = xAxis;
	}
	
	public EchartModel(Series series,XAxis xAxis,List<PointData> pointData,List<Map<String,String>> tdstList,List<Map<String,String>>  stopList){
		this.series[0] = series;
		this.xAxis[0] = xAxis;
		this.pointData = pointData;
		this.tdstList = tdstList;
		this.stopList = stopList;
	} 
	

	public Series[] getSeries() {
		return series;
	}

	public void setSeries(Series[] series) {
		this.series = series;
	}

	public XAxis[] getxAxis() {
		return xAxis;
	}

	public void setxAxis(XAxis[] xAxis) {
		this.xAxis = xAxis;
	}
	
	public List<PointData> getPointData() {
		return pointData;
	}

	public void setPointData(List<PointData> pointData) {
		this.pointData = pointData;
	}
	
	
	public List<Map<String,String>> getTdstList() {
		return tdstList;
	}

	public void setTdstList(List<Map<String,String>> tdstList) {
		this.tdstList = tdstList;
	}

	public List<Map<String,String>> getStopList() {
		return stopList;
	}

	public void setStopList(List<Map<String,String>> stopList) {
		this.stopList = stopList;
	}

}
