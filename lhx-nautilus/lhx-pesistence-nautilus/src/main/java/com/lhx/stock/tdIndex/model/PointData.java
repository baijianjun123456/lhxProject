package com.lhx.stock.tdIndex.model;

import java.util.HashMap;
import java.util.Map;

public class PointData {
	
	private static Map<String,ItemStyle> styleMap = new HashMap<String,ItemStyle>();
	static{
		ItemStyle style_td = new ItemStyle("bottom","red");
		ItemStyle style_cd = new ItemStyle("top","green");
		
		ItemStyle style_td_9 = new ItemStyle("bottom","magenta","13px");
		
		ItemStyle style_cd_13 = new ItemStyle("top","blue","15px");
		
		styleMap.put("TD", style_td);
		styleMap.put("CD", style_cd);
		
		styleMap.put("TD9", style_td_9);
		
		styleMap.put("CD13", style_cd_13);
	}
	
	private String xAxis;
	
	private Double yAxis;
	
	private String value;
	
	private ItemStyle itemStyle;

	private String type;
	
	public String getxAxis() {
		return xAxis;
	}

	public void setxAxis(String xAxis) {
		this.xAxis = xAxis;
	}

	public Double getyAxis() {
		return yAxis;
	}

	public void setyAxis(Double yAxis) {
		this.yAxis = yAxis;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public ItemStyle getItemStyle() {
		return itemStyle;
	}

	public void setItemStyle() {
		if("TD".equals(this.type) && "9".equals(this.value)){
			this.itemStyle = styleMap.get("TD9");
		}
		else if("CD".equals(this.type) && "13".equals(this.value)){
			this.itemStyle = styleMap.get("CD13");
		}
		else{
			this.itemStyle = styleMap.get(this.type);			
		}
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setItemStyle(ItemStyle itemStyle) {
		this.itemStyle = itemStyle;
	}

}
