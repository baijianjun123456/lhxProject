package com.lhx.file.handler.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.lhx.file.constant.DBDataTypeEnum;
import com.lhx.file.copy.context.FileContext;
import com.lhx.file.model.ContextModel;
import com.lhx.file.model.TabColModel;

public class XMLFileHandlerImpl extends AbstractFileHandler{
	
	private static final String WHERE_CONDITION_STR = "\t\t<if test=\"@propName@ != null and @propName@ != ''\">\n\t\t\t AND @columnName@ = #{@propName@,jdbcType=@dataType@}\n\t\t</if>\n";
	
	private static final String UPDATE_FILED_STR = "\t\t<if test=\"@propName@ != null and @propName@ != ''\">\n\t\t\t, @columnName@ = #{@propName@,jdbcType=@dataType@} \n\t\t</if>\n";
	
	@Override
	public void exec(FileContext fileContext, File srcFile_, File descFile_)
			throws IOException {
		
		ContextModel contextModel = fileContext.getContextModel();
		this.buildTabValue(contextModel, contextModel.getTabColList());
		this.buildUpdateFiled(contextModel,  contextModel.getTabColList());
		this.buildWhereCondition(contextModel,  contextModel.getTabColList());
		this.buildMapResult(contextModel,  contextModel.getTabColList());
		super.exec(fileContext, srcFile_, descFile_);
	}

	@Override
	public String handler(FileContext fileContext, String lineText) {
		// TODO Auto-generated method stub
		return super.handler(fileContext, lineText);
	}
	
	/**
	 * 构建where条件；
	 * @param contextModel
	 * @param tabColList
	 */
	private  void buildWhereCondition(ContextModel contextModel,List<TabColModel> tabColList){
		StringBuffer whereConditionBf = new StringBuffer();
		for(TabColModel tabColModel : tabColList){
			String conditonstr = WHERE_CONDITION_STR;
			whereConditionBf.append(conditonstr.replaceAll("@propName@",tabColModel.getPropName()).replaceAll("@columnName@",tabColModel.getColumnName()).replaceAll("@dataType@", tabColModel.getMBDataType()));
		} 
		contextModel.setWhereCondition(whereConditionBf.toString());
	}
	
	public  void buildTabValue(ContextModel contextModel,List<TabColModel> tabColList){
		StringBuffer tabValueBF = new StringBuffer();
		for(TabColModel tabColModel : tabColList){
			tabValueBF.append("#{").append(tabColModel.getPropName()).append(",").append("jdbcType=").append(tabColModel.getMBDataType()).append("},");
		}
		contextModel.setTabValue(tabValueBF.substring(0, tabValueBF.length()-1));
	}
	
	public void buildMapResult(ContextModel contextModel,List<TabColModel> tabColList){
		StringBuffer mapResultBf = new StringBuffer();
		for(TabColModel tabColModel : tabColList){
			//<result property="tableName" column="TABLE_NAME"  javaType="string" jdbcType="VARCHAR"/>
			mapResultBf.append("\t\t<result property=\"").append(tabColModel.getPropName()).append("\" column=\"").append(tabColModel.getColumnName());
			mapResultBf.append("\" javaType=\"").append(DBDataTypeEnum.valueOf(tabColModel.getDBDataType()).getJavaClass()).append("\" jdbcType=\"").append(tabColModel.getDBDataType()).append("\" />").append("\n");
		} 
		contextModel.setMapResult(mapResultBf.toString());
	}
	
	/**
	 * 构建update字段信息；
	 * @param contextModel
	 * @param tabColList
	 */
	private  void buildUpdateFiled(ContextModel contextModel,List<TabColModel> tabColList){
		StringBuffer updateConditionBf = new StringBuffer();
		for(TabColModel tabColModel : tabColList){
			if("ID_".equals(tabColModel.getColumnName())){
				continue;
			}
			String conditonstr = UPDATE_FILED_STR;
			updateConditionBf.append(conditonstr.replaceAll("@propName@",tabColModel.getPropName()).replaceAll("@columnName@",tabColModel.getColumnName()).replaceAll("@dataType@", tabColModel.getMBDataType()));
		} 
		contextModel.setUpdateFiled(updateConditionBf.toString());
	}



}
