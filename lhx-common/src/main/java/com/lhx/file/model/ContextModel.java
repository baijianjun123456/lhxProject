package com.lhx.file.model;

import java.util.List;
import java.util.Map;

import com.lhx.utils.StringUtil;

/**
 * 自动生成Dao层的模型类；
 * @author liangshu
 *
 */
public class ContextModel {
	
	private String tableName;

	//模块名称；
	private String moduleName;
	
	//模块中文名称；
	private String moduleNameCH;
	
	//表列名；
	private String tabColName;
	
	//属性名；
	private String tabValue;
	
	//package路径；
	private String classBusPath;
	
	//where条件；
	private String whereCondition;
	
	//update字段串；
	private String updateFiled;
	
	private Map<String,String> dBFileds;
	
	//需import的class类；
	private String importClass;
	
	//model属性串；
	private String javaProperties;
	
	//set,get方法；
	private String getSetMethods;
	
	//构造方法；
	private String constructors;
	
	//表列的定义信息列表；
	private  List<TabColModel> tabColList;
	
	//模块名称首字母大写
	private  String fmoduleName;
	
	//grid表格列定义；
	private String columns;
	
	//搜索表单
	private String searchForm;
	
	//业务表单
	private String addForm;
	
	//表字段和实体类属性mapresult映射关系
	private String mapResult;
	
	public String getMapResult() {
		return mapResult;
	}

	public void setMapResult(String mapResult) {
		this.mapResult = mapResult;
	}

	public String getAddForm() {
		return addForm;
	}

	public void setAddForm(String addForm) {
		this.addForm = addForm;
	}

	public String getSearchForm() {
		return searchForm;
	}

	public void setSearchForm(String searchForm) {
		this.searchForm = searchForm;
	}

	public String getColumns() {
		return columns;
	}

	public void setColumns(String columns) {
		this.columns = columns;
	}

	public List<TabColModel> getTabColList() {
		return tabColList;
	}

	public void setFmoduleName(String fmoduleName) {
		this.fmoduleName = fmoduleName;
	}

	public void setTabColList(List<TabColModel> tabColList) {
		this.tabColList = tabColList;
	}

	public String getConstructors() {
		return constructors;
	}

	public void setConstructors(String constructors) {
		this.constructors = constructors;
	}

	public String getGetSetMethods() {
		return getSetMethods;
	}

	public void setGetSetMethods(String getSetMethods) {
		this.getSetMethods = getSetMethods;
	}

	public String getImportClass() {
		return importClass;
	}

	public void setImportClass(String importClass) {
		this.importClass = importClass;
	}

	public String getJavaProperties() {
		return javaProperties;
	}

	public void setJavaProperties(String javaProperties) {
		this.javaProperties = javaProperties;
	}

	public Map<String, String> getdBFileds() {
		return dBFileds;
	}

	public void setdBFileds(Map<String, String> dBFileds) {
		this.dBFileds = dBFileds;
	}

	public ContextModel(String tableName_,String classBusPath_,String moduleName_,String moduleNameCH_){
		this.tableName = tableName_;
		this.classBusPath = classBusPath_;
		this.moduleName = moduleName_;
		this.moduleNameCH = moduleNameCH_;
	}
	
	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getModuleName() {
		return moduleName;
	}

	public String getFmoduleName() {
		fmoduleName = StringUtil.lowerFirst(moduleName);
		return fmoduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	
	public String getClassBusPath() {
		return classBusPath;
	}

	public void setClassBusPath(String classBusPath) {
		this.classBusPath = classBusPath;
	}
	
	public String getWhereCondition() {
		return whereCondition;
	}

	public void setWhereCondition(String whereCondition) {
		this.whereCondition = whereCondition;
	}

	public String getUpdateFiled() {
		return updateFiled;
	}

	public void setUpdateFiled(String updateFiled) {
		this.updateFiled = updateFiled;
	}
	
	public String getTabColName() {
		return tabColName;
	}

	public void setTabColName(String tabColName) {
		this.tabColName = tabColName;
	}

	public String getTabValue() {
		return tabValue;
	}

	public void setTabValue(String tabValue) {
		this.tabValue = tabValue;
	}
	
	public String getModuleNameCH() {
		return moduleNameCH;
	}

	public void setModuleNameCH(String moduleNameCH) {
		this.moduleNameCH = moduleNameCH;
	}

	public String getParentmoduleName(){
		return classBusPath.split("\\.")[0];
	}
}
