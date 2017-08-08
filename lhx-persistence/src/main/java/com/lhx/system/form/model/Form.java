package com.lhx.system.form.model;

import java.io.Serializable;

import com.lhx.common.mybatis.BaseModel;
import com.lhx.file.model.TabColModel;
import com.lhx.utils.UUIDUtil;


/**
 * 表单管理定义模型；
 * @author liangshu
 */
public class Form extends BaseModel implements Serializable {

	private static final long serialVersionUID = 1L;

	//表单名称
	private String tableName;

	//变单项名称
	private String columnName;

	//变单项中文名称
	private String columnNameCh;

	//数据类型
	private String dataType;

	//数据长度
	private String dataLength;

	//显示长度
	private String displayLength;

	//是否为空
	private String nullable5;

	//是否为搜索项
	private String isSearch;

	//是否显示为列项
	private String isList;

	//是否显示为编辑项
	private String isEdit;

	//0：来源于表；1：来源于数据字典
	private String sourceType;

	//
	private String sourceValue;

	public static Form newInstance(){
		Form form = new Form();
		return form;
	}
	
	public static Form convert(TabColModel tabColModel){
		Form form = Form.newInstance();
		form.setId_(UUIDUtil.getUUID());
		form.setTableName(tabColModel.getTableName());
		form.setColumnName(tabColModel.getColumnName());
		form.setColumnNameCh(tabColModel.getColumnComments());
		form.setDataType(tabColModel.getDBDataType());
		form.setDisplayLength("100");
		form.setDataLength(tabColModel.getDataLength());
		form.setNullable5(tabColModel.getIsNull());
		form.setIsSearch("Y");
		form.setIsList("Y");
		form.setIsEdit("Y");
		return form;
				
	}
	

	public String getTableName(){
		if(this.tableName != null){
			this.tableName = this.tableName.toUpperCase();
		}
		return this.tableName;
	}
	public void setTableName(String tableName_){
		this.tableName = tableName_;
	}
	public String getColumnName(){
		return this.columnName;
	}
	public void setColumnName(String columnName_){
		this.columnName = columnName_;
	}
	public String getColumnNameCh(){
		return this.columnNameCh;
	}
	public void setColumnNameCh(String columnNameCh_){
		this.columnNameCh = columnNameCh_;
	}
	public String getDataType(){
		return this.dataType;
	}
	public void setDataType(String dataType_){
		this.dataType = dataType_;
	}
	public String getDataLength(){
		return this.dataLength;
	}
	public void setDataLength(String dataLength_){
		this.dataLength = dataLength_;
	}
	public String getDisplayLength(){
		return this.displayLength;
	}
	public void setDisplayLength(String displayLength_){
		this.displayLength = displayLength_;
	}
	public String getNullable5(){
		return this.nullable5;
	}
	public void setNullable5(String nullable5_){
		this.nullable5 = nullable5_;
	}
	public String getIsSearch(){
		return this.isSearch;
	}
	public void setIsSearch(String isSearch_){
		this.isSearch = isSearch_;
	}
	public String getIsList(){
		return this.isList;
	}
	public void setIsList(String isList_){
		this.isList = isList_;
	}
	public String getIsEdit(){
		return this.isEdit;
	}
	public void setIsEdit(String isEdit_){
		this.isEdit = isEdit_;
	}
	public String getSourceType(){
		return this.sourceType;
	}
	public void setSourceType(String sourceType_){
		this.sourceType = sourceType_;
	}
	public String getSourceValue(){
		return this.sourceValue;
	}
	public void setSourceValue(String sourceValue_){
		this.sourceValue = sourceValue_;
	}

} 
