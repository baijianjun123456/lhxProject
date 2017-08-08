package com.lhx.stock.tdIndex.model;

public class Label {
	
	private String position;
	
	private TextStyle textStyle;
	
	public Label(String position){
		this.position = position;
	}
	
	public Label(String position,String fontSize){
		this.position = position;
		this.textStyle = new TextStyle(fontSize);
	}
	
	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
	
	public TextStyle getTextStyle() {
		return textStyle;
	}

	public void setTextStyle(TextStyle textStyle) {
		this.textStyle = textStyle;
	}


	class TextStyle{
		
		private String fontSize ;
		
		private String fontWeight = "bold";
		
		public String getFontWeight() {
			return fontWeight;
		}

		public void setFontWeight(String fontWeight) {
			this.fontWeight = fontWeight;
		}

		public TextStyle(String fontSize){
			this.fontSize = fontSize;
		}
		
		public String getFontSize() {
			return fontSize;
		}

		public void setFontSize(String fontSize) {
			this.fontSize = fontSize;
		}

	}


}
