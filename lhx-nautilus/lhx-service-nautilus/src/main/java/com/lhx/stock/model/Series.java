package com.lhx.stock.model;

import java.util.List;
import com.lhx.stock.market.model.Market;

public class Series {
	
	private String name = "上证指数";
	
	private String type = "k";
	
	private Double[][] data;
	
	public Series(String name){
		this.name = name;
	}
	
	public Series(String name,String type){
		this.name = name;
		this.type = type;	
	}
	
	public Series(List<Market> dataList){
		this.covertData(dataList);
	}

	public Series(String name,String type,List<Market> dataList){
		this.name = name;
		this.type = type;
		this.covertData(dataList);
	}	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double[][] getData() {
		return data;
	}

	public void setData(Double[][] data) {
		this.data = data;
	}
	
    private void  covertData(List<Market> marketList){
    	data = new Double[marketList.size()][4];
    	for(int i = 0 ; i < marketList.size(); i++){
    		data[i] = marketList.get(i).toArray();
		}
    }

}
