package com.lhx.stock.market.model;

import java.io.Serializable;
import com.lhx.common.mybatis.BaseModel;

/**
 * 股票行情定义模型；
 * @author liangshu
 */
public class Market extends BaseModel implements Serializable {

	private static final long serialVersionUID = 1L;

	//股票编码
	private String tcode;

	//股票名称
	private String tname;

	//某个时间的行情数据（必输*）
	private String time;

	//开盘价（必输*）
	private Double open;

	//收盘价（必输*）
	private Double close;

	//最高价（必输*）
	private Double high;

	//最低价（必输*）
	private Double low;
	
	//序号
	private int seq;

	public static Market newInstance(String tcode){
		Market market = new Market();
		market.setTcode(tcode);
		return market;
	}
	
	public static Market newInstance(String id__,String time_,Double open_,Double close_,Double high_,Double low_){
		Market market = new Market();
		market.setId_(id__);
		market.setTime(time_);
		market.setOpen(open_);
		market.setClose(close_);
		market.setHigh(high_);
		market.setLow(low_);
		return market;
	}

	public String getTcode(){
		return this.tcode;
	}
	public void setTcode(String tcode_){
		this.tcode = tcode_;
	}
	public String getTname(){
		return this.tname;
	}
	public void setTname(String tname_){
		this.tname = tname_;
	}
	public String getTime(){
		return this.time;
	}
	public void setTime(String time_){
		this.time = time_;
	}
	public Double getOpen(){
		return this.open;
	}
	public void setOpen(Double open_){
		this.open = open_;
	}
	public Double getClose(){
		return this.close;
	}
	public void setClose(Double close_){
		this.close = close_;
	}
	public Double getHigh(){
		return this.high;
	}
	public void setHigh(Double high_){
		this.high = high_;
	}
	public Double getLow(){
		return this.low;
	}
	public void setLow(Double low_){
		this.low = low_;
	}
	
	public Double[] toArray() {
		Double[] marketInfo = {this.open,this.close,this.low,this.high};
		return marketInfo;
	}
	
	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

} 
