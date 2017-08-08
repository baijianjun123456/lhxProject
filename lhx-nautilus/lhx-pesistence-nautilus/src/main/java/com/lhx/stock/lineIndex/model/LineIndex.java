package com.lhx.stock.lineIndex.model;

import java.io.Serializable;

import com.lhx.common.mybatis.BaseModel;


/**
 * TD指标线定义模型；
 * @author liangshu
 */
public class LineIndex extends BaseModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id_;
	
	//1:TDST_LINE(止盈线); 2:STOP_LINE(止损线)
	private String type ;
	
	private String xtimes;
	
	//止损线时间列表；
	private StringBuffer xtimesBuf = null;
	
	//止损线y轴值；
	private Double yValue = -1.0;
	
	//趋势
	private String stTrend;
	
	public LineIndex(String id_,String stTrend,String type){
		this.stTrend = stTrend;
		this.id_ = id_;
		this.type = type;
	}

	public Double getYValue() {
		return yValue;
	}

	public void setyYValue(Double value) {
		if("DOWN".equals(stTrend)){
			if(yValue < value || yValue == -1.0){
				yValue = value;
			}
		}
		else if("UP".equals(stTrend)){
			if(yValue > value || yValue == -1.0){
				yValue = value;
			}
		}
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getXtimes() {
		return this.xtimes;
	}

	public void setXtimes(String time) {
		if(xtimesBuf == null){
			xtimesBuf = new StringBuffer();
			xtimesBuf.append(time);
		}
		else{
			xtimesBuf.append(",").append(time);
		}
		
		this.xtimes = xtimesBuf.toString();
	}
	
	public String getStTrend() {
		return stTrend;
	}

	public void setStTrend(String stTrend) {
		this.stTrend = stTrend;
	}
	
	public String getId_() {
		return id_;
	}

	public void setId_(String id_) {
		this.id_ = id_;
	}


} 
