package com.lhx.timerTask;

import java.util.Map;

/**
 * 定时器实体类
 * @author liangshu
 *
 */
public class TimerEntity {
	
	//定时器ID;
	private  String  id_;
	
	//定时器名称；
	private  String  name;
	
	//定时器描述；
	private  String desc;
	
	//业务执行类
	private  String className;
	
	//开始时间；
	private  String startTime;
	
	//结束时间；
	private  String endTime;
	
	//间隔执行时间；
	private  String intervalTime;
	
	//启动定时器需传入的参数；
	private Map<String,String> paramMap;
	
	//定时器当前状态（on：运行中；off：停止运行）
	private String state;

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getId_() {
		return id_;
	}

	public void setId_(String id_) {
		this.id_ = id_;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getIntervalTime() {
		return intervalTime;
	}

	public void setIntervalTime(String intervalTime) {
		this.intervalTime = intervalTime;
	}

	public Map<String, String> getParamMap() {
		return paramMap;
	}

	public void setParamMap(Map<String, String> paramMap) {
		this.paramMap = paramMap;
	}

}
