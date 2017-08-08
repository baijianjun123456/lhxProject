package com.lhx.stock.tdIndex.model;

import java.io.Serializable;
import com.lhx.stock.market.model.Market;

/**
 * TD指标定义模型；
 * @author liangshu
 */
public class TDIndex extends Market implements Serializable {

	private static final long serialVersionUID = 1L;

	//ST计算值
	private int stCount;

	//CD计数值
	private int cdCount = -999;

	//ST计数阶段ID
	private String stPhaseId;

	//TD计数阶段ID
	private String cdPhaseId;

	//ST阶段结构趋势(UP：上升，DOWN:下降)
	private String stTrend;

	//CD阶段结构趋势()
	private String cdTrend;

	//ST计数拐点时间
	private String stBp;

	//CD计数拐点时间
	private String cdBp;

	//显示内容
	private String displayContent;

	public static TDIndex newInstance(String id__){
		TDIndex tDIndex = new TDIndex();
		tDIndex.setId_(id__);
		return tDIndex;
	}

	public int getStCount(){
		return this.stCount;
	}
	public void setStCount(int stCount_){
		this.stCount = stCount_;
	}
	public int getCdCount(){
		return this.cdCount;
	}
	public void setCdCount(int cdCount_){
		this.cdCount = cdCount_;
	}
	public String getStPhaseId(){
		return this.stPhaseId;
	}
	public void setStPhaseId(String stPhaseId_){
		this.stPhaseId = stPhaseId_;
	}
	public String getCdPhaseId(){
		return this.cdPhaseId;
	}
	public void setCdPhaseId(String cdPhaseId_){
		this.cdPhaseId = cdPhaseId_;
	}
	public String getStTrend(){
		return this.stTrend;
	}
	public void setStTrend(String stTrend_){
		this.stTrend = stTrend_;
	}
	public String getCdTrend(){
		return this.cdTrend;
	}
	public void setCdTrend(String cdTrend_){
		this.cdTrend = cdTrend_;
	}
	public String getStBp(){
		return this.stBp;
	}
	public void setStBp(String stBp_){
		this.stBp = stBp_;
	}
	public String getCdBp(){
		return this.cdBp;
	}
	public void setCdBp(String cdBp_){
		this.cdBp = cdBp_;
	}
	public String getDisplayContent(){
		return this.displayContent;
	}
	public void setDisplayContent(String displayContent_){
		this.displayContent = displayContent_;
	}

} 
