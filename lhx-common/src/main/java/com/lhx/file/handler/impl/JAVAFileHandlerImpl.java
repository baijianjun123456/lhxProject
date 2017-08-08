package com.lhx.file.handler.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.util.StringUtils;

import com.lhx.file.constant.DBDataTypeEnum;
import com.lhx.file.copy.context.FileContext;
import com.lhx.file.factory.ContextModelFactory;
import com.lhx.file.model.ContextModel;
import com.lhx.file.model.TabColModel;
import com.lhx.utils.StringUtil;


public class JAVAFileHandlerImpl extends AbstractFileHandler {

	@Override
	public void exec(FileContext fileContext, File srcFile_, File descFile_)
			throws IOException {
		
		ContextModel contextModel = fileContext.getContextModel();
		this.buildImportClass(contextModel, contextModel.getTabColList());
		this.buildJavaProperties(contextModel, contextModel.getTabColList());
		this.buildConstructor(contextModel, contextModel.getTabColList());
		this.buildGetSetMethods(contextModel, contextModel.getTabColList());
		
		super.exec(fileContext, srcFile_, descFile_);
	}
	
	/**
	 * 构建导入import类；
	 * @param contextModel
	 * @param tabColList
	 */
	private void buildImportClass(ContextModel contextModel,List<TabColModel> tabColList){
		StringBuffer improtClassBF = new StringBuffer();
		for(TabColModel tabColModel : tabColList){
			String importClass = DBDataTypeEnum.valueOf(tabColModel.getDBDataType()).getJavaImportClass();
			if(!StringUtils.isEmpty(importClass)){
				improtClassBF.append("import ").append(DBDataTypeEnum.valueOf(tabColModel.getDBDataType()).getJavaImportClass()).append(";\n");
			}
		}
		contextModel.setImportClass(improtClassBF.toString());
	}
	
	/**
	 * 构建模型的属性；
	 * @param contextModel
	 * @param tabColList
	 */
	private void buildJavaProperties(ContextModel contextModel,List<TabColModel> tabColList){
		StringBuffer javaPropertiesBF = new StringBuffer();
		for(TabColModel tabColModel : tabColList){
			if(ContextModelFactory.filterFiledList.contains(tabColModel.getColumnName())){
				continue;
			}
			javaPropertiesBF.append("\n\t//").append(tabColModel.getColumnComments());
			if("N".equals(tabColModel.getIsNull())){
				javaPropertiesBF.append("（必输*）");
			}
			javaPropertiesBF.append("\n");
			javaPropertiesBF.append("\tprivate ").append(DBDataTypeEnum.valueOf(tabColModel.getDBDataType()).getJavaClass()).append(" ").append(tabColModel.getPropName()).append(";\n");
		}
		contextModel.setJavaProperties(javaPropertiesBF.toString());
	}
	
	/**
	 * 构建构造方法；
	 * @param contextModel
	 * @param tabColList
	 */
	private void buildConstructor(ContextModel contextModel,List<TabColModel> tabColList){
		StringBuffer constructorBF = new StringBuffer();
		
		//无参默认构造方法；
		//constructorBF.append("\tpublic ").append(contextModel.getModuleName()).append("(){");
		//constructorBF.append("\n\n\t}\n");
		
		StringBuffer methodBF = new StringBuffer();
		methodBF.append("\tpublic static "+contextModel.getModuleName()+" newInstance").append("(");
		String moduleName = contextModel.getModuleName();
		String lowerFirstmoduleName = moduleName.replace(moduleName.substring(0, 1), moduleName.substring(0, 1).toLowerCase());
		StringBuffer filedBF = new StringBuffer();
		for(TabColModel tabColModel : tabColList){
			String javaClass = DBDataTypeEnum.valueOf(tabColModel.getDBDataType()).getJavaClass();
			String propertieName = tabColModel.getPropName();
			if("N".equals(tabColModel.getIsNull()) || "NO".equals(tabColModel.getIsNull())){
				methodBF.append(javaClass).append(" ").append(propertieName+"_").append(",");
				filedBF.append("\n\t\t");
				String propertieMethod = StringUtil.upperFirst(propertieName);
				filedBF.append(lowerFirstmoduleName+".set").append(propertieMethod+"(").append(propertieName+"_)").append(";");
			}
		}	
		constructorBF.append(methodBF.substring(0, methodBF.length()-1)).append("){");
		constructorBF.append("\n\t\t").append(moduleName).append(" "+lowerFirstmoduleName).append(" = new ").append(moduleName+"();");		
		constructorBF.append(filedBF.toString());
		constructorBF.append("\n\t\treturn ").append(lowerFirstmoduleName).append(";");
		constructorBF.append("\n\t}\n");
		contextModel.setConstructors(constructorBF.toString());
	}
	
	/**
	 * 构建模型set，get方法；
	 * @param contextModel
	 * @param tabColList
	 */
	private void buildGetSetMethods(ContextModel contextModel,List<TabColModel> tabColList){
		StringBuffer getSetMethodsBF = new StringBuffer();
		for(TabColModel tabColModel : tabColList){
			
			if(ContextModelFactory.filterFiledList.contains(tabColModel.getColumnName())){
				continue;
			}
			
			String javaClass = DBDataTypeEnum.valueOf(tabColModel.getDBDataType()).getJavaClass();
			String propertieName = tabColModel.getPropName();
			String propertieMethod = StringUtil.upperFirst(propertieName);
			
			//设置get方法；
			getSetMethodsBF.append("\tpublic ").append(javaClass).append(" get").append(propertieMethod).append("(){\n");
			getSetMethodsBF.append("\t\treturn this.").append(propertieName).append(";");
			getSetMethodsBF.append("\n\t}\n");
			
			//设置set方法；
			getSetMethodsBF.append("\tpublic ").append("void").append(" set").append(propertieMethod).append("(").append(javaClass).append(" "+ propertieName+"_").append("){\n");
			getSetMethodsBF.append("\t\tthis.").append(propertieName).append(" = ").append(propertieName+"_;");
			getSetMethodsBF.append("\n\t}\n");
		}
		contextModel.setGetSetMethods(getSetMethodsBF.toString());
	}
	
}
