package com.lhx.stock.self.model;

import java.io.Serializable;
import com.lhx.common.mybatis.BaseModel;


/**
 * 自选股定义模型；
 * @author liangshu
 */
public class StockSelf extends BaseModel implements Serializable {

	private static final long serialVersionUID = 1L;

	//用户ID
	private String userId;

	//股票编码
	private String tcode;

	//股票名称
	private String tname;

	public static StockSelf newInstance(String id__){
		StockSelf stockself = new StockSelf();
		stockself.setId_(id__);
		return stockself;
	}

	public String getUserId(){
		return this.userId;
	}
	public void setUserId(String userId_){
		this.userId = userId_;
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

} 
