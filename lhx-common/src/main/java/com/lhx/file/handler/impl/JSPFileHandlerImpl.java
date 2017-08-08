package com.lhx.file.handler.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.lhx.file.copy.context.FileContext;
import com.lhx.file.factory.ContextModelFactory;
import com.lhx.file.model.ContextModel;
import com.lhx.file.model.TabColModel;

public class JSPFileHandlerImpl  extends AbstractFileHandler{
	

	@Override
	public void exec(FileContext fileContext, File srcFile_, File descFile_)
			throws IOException {
		
		buildSearchForm(fileContext.getContextModel());
		super.exec(fileContext, srcFile_, descFile_);
	}
	
	/**
	 * 构建搜索表单；
	 * @param contextModel
	 * @param tabColList
	 */
	private void buildSearchForm(ContextModel contextModel){
		
		StringBuffer searchFormBF = new StringBuffer();
		List<TabColModel> tabColList =contextModel.getTabColList();
		
		int displayIndex = -1;
		for(int index = 0 ; index < tabColList.size();index++){
			
			
			TabColModel tabColModel = tabColList.get(index);
			if(("N".equals(tabColModel.getIsNull()) && !ContextModelFactory.filterFiledList.contains(tabColModel.getColumnName())) || "NAME".equals(tabColModel.getColumnName())){
				
				++displayIndex;
				
				if(displayIndex%6 == 0){
					searchFormBF.append("\n").append(getFomatMark("\t",7)).append("<tr>");
				}
				
				searchFormBF.append("\n").append(getFomatMark("\t",8)).append("<td class='title'>").append(tabColModel.getColumnComments()).append(":</td>");
				searchFormBF.append("<td><input isSearch='istrue' class='easyui-textbox content' type='text'"); 
				searchFormBF.append(" name=").append(tabColModel.getPropName()).append(" value='\\${result.").append(tabColModel.getPropName()).append("}'></input></td>"); 
				
				
				if((displayIndex)%5 == 0 && displayIndex != 0){
					searchFormBF.append("\n").append(getFomatMark("\t",7)).append("</tr>");
				}
				
				
			}
			
		}
		
		if(displayIndex%5 != 0){
			searchFormBF.append("\n").append(getFomatMark("\t",7)).append("</tr>");
		}
		
		searchFormBF.append("\n").append(getFomatMark("\t",7)).append("<tr>\n").append(getFomatMark("\t",7)).append("<td colspan='10' style='text-align:center;' >");
		searchFormBF.append("\n").append(getFomatMark("\t",9)).append("<a class='easyui-linkbutton buttonq' iconCls='icon-search' id='submitid'>查询</a>");
		searchFormBF.append("\n").append(getFomatMark("\t",9)).append("<a class='easyui-linkbutton buttonq' iconCls='icon-reload'>重置</a>");
		searchFormBF.append("\n").append(getFomatMark("\t",8)).append("</td>");
		searchFormBF.append("\n").append(getFomatMark("\t",7)).append("</tr>");
		contextModel.setSearchForm(searchFormBF.toString());
	}
	
	private String getFomatMark(String specailChar,int num){
		StringBuffer markBF = new StringBuffer();

		for(int i = 0 ; i < num ; i++){
			markBF.append(specailChar);
		}
		return markBF.toString();
	}
	
	/**
	 * 构建新增表单；
	 * @param contextModel
	 * @param tabColList
	 */
	private void buildAddForm(ContextModel contextModel){
		StringBuffer addFormBF = new StringBuffer();
		List<TabColModel> tabColList =contextModel.getTabColList();
		addFormBF.append("");
		for(int index = 0 ; index < tabColList.size();index++){
			
			TabColModel tabColModel = tabColList.get(index);
			
			if(index != 0){
				addFormBF.append(",\n");
			}
			addFormBF.append("\t\t").append("{field:'").append(tabColModel.getPropName()).append("',title").append(":'").append(tabColModel.getColumnComments()).append("'");
			addFormBF.append(",width:").append(Double.toString(Integer.parseInt(tabColModel.getDataLength())/3));
			addFormBF.append("}");
			
		}
		addFormBF.append("\n\t\t").append("]];");
		contextModel.setColumns(addFormBF.toString());
	}

}
