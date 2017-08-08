package com.lhx.stock.info.model;

import java.io.Serializable;
import com.lhx.common.mybatis.BaseModel;


/**
 * 股票基础信息表定义模型；
 * @author liangshu
 */
public class StockInfo extends BaseModel implements Serializable {

	private static final long serialVersionUID = 1L;

	//股票编码（必输*）
	private String code;

	//A股，B股，H股，N股、S股
	private String type;

	public static StockInfo newInstance(String id__,String code_,String name_,String type_){
		StockInfo stockInfo = new StockInfo();
		stockInfo.setId_(id__);
		stockInfo.setCode(code_);
		stockInfo.setName(name_);
		stockInfo.setType(type_);
		return stockInfo;
	}

	public String getCode(){
		return this.code;
	}
	public void setCode(String code_){
		this.code = code_;
	}
	public String getType(){
		return this.type;
	}
	public void setType(String type_){
		this.type = type_;
	}

} 
