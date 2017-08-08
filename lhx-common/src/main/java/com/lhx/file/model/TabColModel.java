package com.lhx.file.model;

import java.io.Serializable;
import java.text.Normalizer.Form;

import com.lhx.file.constant.DBDataTypeEnum;
import com.lhx.utils.StringUtil;

/**
 *表列定义模型
 * @author liangshu
 *
 */
public class TabColModel implements Serializable{
	
	//表名；
	private String tableName;
	
	//列名；
	private String columnName;
	
	private String columnNameCN;

	//列数据类型；tableName
	private String DBDataType;
	
	//列注释；
	private String columnComments;

	//列长度；
	private String dataLength;
	
	//该字段是否为空：（N:不能为空；Y:可以为空）
	private String isNull;
	
	//当前字段是否为检索条件
	private String isSearch;
	
	//当前字段是否在列表中展示
	private String isList;
	
	//当前字段是否可编辑
	private String isEdit;
	
	//当期那字段数据来源类型（0：来源于表；1：来源于数据字典）
	private String sourceType;
	
	//当前字段来源值信息；
	private String sourceValue;
	
	//显示宽度；
	private String displayLength;

	public String getIsNull() {
		if("NO".equals(isNull)){
			isNull = "N";
		}
		if("YES".equals(isNull)){
			isNull = "Y";
		}
		return isNull;
	}

	public void setIsNull(String isNull) {
		this.isNull = isNull;
	}

	public TabColModel(){
		
	}
	
	public TabColModel(String tableName_){
		this.tableName = tableName_.toUpperCase();
	}
	
	public String getColumnComments() {
		return columnComments;
	}

	public void setColumnComments(String columnComments) {
		this.columnComments = columnComments;
	}

	public String getDBDataType() {
		if(DBDataType.indexOf("TIMESTAMP") != -1){
			DBDataType = "TIMESTAMP";
		}
		return DBDataType.toUpperCase();
	}

	public void setDBDataType(String dBDataType) {
		DBDataType = dBDataType;
	}

	public String getMBDataType() {
		return DBDataTypeEnum.covertMBDataType(DBDataType.toUpperCase());
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	
	public String getTableName() {
		return tableName.toUpperCase();
	}

	public void setTableName(String tableName_) {
		this.tableName = tableName_.toUpperCase();
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnname(String columnName_) {
		this.columnName = columnName_;
	}

	public String getDataLength() {
		return dataLength;
	}

	public void setDataLength(String dataLength) {
		this.dataLength = dataLength;
	}
	
	public String getPropName() {
		return StringUtil.bdToProp(columnName);
	}

	public String getColumnNameCN() {
		return columnNameCN;
	}

	public void setColumnNameCN(String columnNameCN) {
		this.columnNameCN = columnNameCN;
	}

	public String getIsSearch() {
		return isSearch;
	}

	public void setIsSearch(String isSearch) {
		this.isSearch = isSearch;
	}

	public String getIsList() {
		return isList;
	}

	public void setIsList(String isList) {
		this.isList = isList;
	}

	public String getIsEdit() {
		return isEdit;
	}

	public void setIsEdit(String isEdit) {
		this.isEdit = isEdit;
	}

	public String getSourceType() {
		return sourceType;
	}

	public void setSourceType(String sourceType) {
		this.sourceType = sourceType;
	}

	public String getSourceValue() {
		return sourceValue;
	}

	public void setSourceValue(String sourceValue) {
		this.sourceValue = sourceValue;
	}

	public String getDisplayLength() {
		return displayLength;
	}

	public void setDisplayLength(String displayLength) {
		this.displayLength = displayLength;
	}
	
}
