package com.lhx.file.handler.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.lhx.file.copy.context.FileContext;
import com.lhx.file.factory.ContextModelFactory;
import com.lhx.file.model.ContextModel;
import com.lhx.file.model.TabColModel;

public class JSFileHandlerImpl extends AbstractFileHandler{

	@Override
	public void exec(FileContext fileContext, File srcFile_, File descFile_)
			throws IOException {
		buildColumns(fileContext.getContextModel());
		super.exec(fileContext, srcFile_, descFile_);
	}
	
	/**
	 * 构建Grid列信息；
	 * @param contextModel
	 * @param tabColList
	 */
	private void buildColumns(ContextModel contextModel){
		StringBuffer columnsBF = new StringBuffer();
		List<TabColModel> tabColList =contextModel.getTabColList();
		columnsBF.append("var columns  = [[").append("\n");
		
		int count = -1;
		for(int index = 0 ; index < tabColList.size();index++){
			
			
			
			TabColModel tabColModel = tabColList.get(index);
			
			if(!"NAME".equals(tabColModel.getColumnName()) && ContextModelFactory.filterFiledList.contains(tabColModel.getColumnName())){
				continue;
			}
			
			++count;
			if(count != 0){
				columnsBF.append(",\n");
			}
			columnsBF.append("\t\t").append("{field:'").append(tabColModel.getPropName()).append("',title").append(":'").append(tabColModel.getColumnComments()).append("'");
			columnsBF.append(",width:").append(Double.toString(Integer.parseInt(tabColModel.getDataLength())*10));
			columnsBF.append("}");
			
		}
		columnsBF.append("\n\t\t").append("]];");
		contextModel.setColumns(columnsBF.toString());
	}
}
