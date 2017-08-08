package com.lhx.stock.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XAxis {
	
	private String type = " ";
	
	private boolean boundaryGap = true ;
	
	private Map<String,String> axisTick = new HashMap<String,String>();
	
	private Map<String,String> splitLine = new HashMap<String,String>();
	
	private Object[] data;
	
	public XAxis(List<String> data){
		this.setAxisTick("onGap","false");
		this.setSplitLine("show","false");
		this.data = data.toArray();
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean getBoundaryGap() {
		return boundaryGap;
	}

	public void setBoundaryGap(boolean boundaryGap) {
		this.boundaryGap = boundaryGap;
	}

	public Map<String,String> getAxisTick() {
		return axisTick;
	}

	public void setAxisTick(String key,String value) {
		this.axisTick.put(key, value);
	}

	public Map<String,String> getSplitLine() {
		return splitLine;
	}

	public void setSplitLine(String key,String value) {
		this.splitLine.put(key, value);
	}

	public Object[] getData() {
		return data;
	}

	public void setData(Object[] data) {
		this.data = data;
	}
}
