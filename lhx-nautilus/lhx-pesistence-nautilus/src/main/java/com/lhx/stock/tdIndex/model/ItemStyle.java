package com.lhx.stock.tdIndex.model;

public class ItemStyle {
	
	private Normal normal;
	
	public ItemStyle(String position,String color){
		this.normal = new Normal(position,color);
	}
	
	public ItemStyle(String position,String color,String fontSize){
		this.normal = new Normal(position,color,fontSize);
	}
	
	public Normal getNormal() {
		return normal;
	}

	public void setNormal(Normal normal) {
		this.normal = normal;
	}


}
