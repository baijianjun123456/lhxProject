package com.lhx.file.constant;

/**
 * 数据库数据类型定义
 * @author gaopj
 *
 */
public enum DBDataTypeEnum {
	
	VARCHAR("VARCHAR","","String"),VARCHAR2("VARCHAR","","String"),BLOB("BLOB","java.sql.Blob","Blob"),CHAR("CHAR","","char"),CLOB("CLOB","java.sql.Clob","Clob"),DATE("DATE","java.sql.Date","Date"),NCHAR("NCHAR","","String"),DECIMAL("DECIMAL","java.math.BigDecimal","BigDecimal"),TIMESTAMP("TIMESTAMP","java.sql.Timestamp","Timestamp")
	,INTEGER("INTEGER","","Integer"),LONG("LONG","","Long"),NUMBER("NUMERIC","java.math.BigDecimal","BigDecimal");
	
	private String value;
	
	private String javaImportClass;
	
	private String javaClass;
	
	private DBDataTypeEnum(String value_,String javaImportClass_,String javaClass_){
		this.value = value_;
		this.javaImportClass = javaImportClass_;
		this.javaClass = javaClass_;
	}
	
	public String getValue(){
		return this.value;
	}
	public static String covertMBDataType(String dbDataType){
		DBDataTypeEnum dbtype =  null;
		if(dbDataType.indexOf("TIMESTAMP") != -1){
			dbtype = DBDataTypeEnum.valueOf("TIMESTAMP");
		}
		else{
			dbtype = DBDataTypeEnum.valueOf(dbDataType);
		}
		
		return dbtype.getValue();
	}
	
	public  String getJavaImportClass(){
		return javaImportClass;
	}
	
	public  String getJavaClass(){
		return javaClass;
	}

}
