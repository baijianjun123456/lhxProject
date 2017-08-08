package com.lhx.stock.tdIndex.model;

public class Normal {
	
	private Label label;
	
	private String color;
	
	public Normal(String position,String color){
		this.label = new Label(position);
		this.color = color;
	}
	
	public Normal(String position,String color,String fontSize){
		this.label = new Label(position,fontSize);
		this.color = color;
	}
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	public Label getLabel() {
		return label;
	}

	public void setLabel(Label label) {
		this.label = label;
	}

	

}
