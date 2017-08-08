package com.lhx.file.factory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.lhx.file.model.ContextModel;
import com.lhx.file.model.TabColModel;
import com.lhx.utils.StringUtil;

public class ContextModelFactory {
	
	public static  List<String> filterFiledList = new ArrayList<String>(); 
	static{
		filterFiledList.add("ID_");
		filterFiledList.add("NAME");
		filterFiledList.add("CREATET");
		filterFiledList.add("CREATEP");
		filterFiledList.add("STATUS");
	}
	
	
	public static ContextModel create(List<TabColModel> tabColList,String tableName,String classBusPath,String moduleName,String moduleNameCH){
		ContextModel contextModel = new ContextModel(tableName,classBusPath,moduleName,moduleNameCH);
		ContextModelFactory.cortMap(contextModel, tabColList);
		
		contextModel.setTabColList(tabColList);

		return contextModel;
	}
	
	/**
	 * 将表的列信息转换成MAP，key：列名，value:列数据类型；
	 * @param tabColList
	 * @return
	 */
	private static void cortMap(ContextModel contextModel,List<TabColModel> tabColList){
		Map<String,String> tabColMap = new HashMap<String,String>();
		StringBuffer dBFiledsBF = new StringBuffer();
		StringBuffer propFiledsBF = new StringBuffer();
		for(TabColModel tabColModel : tabColList){
			String column_name = tabColModel.getColumnName();
			String dataType = tabColModel.getDBDataType();
			tabColMap.put(column_name, dataType);
			dBFiledsBF.append(column_name).append(",");
			propFiledsBF.append(StringUtil.bdToProp(column_name)).append(",");
		}
		contextModel.setdBFileds(tabColMap);
		contextModel.setTabColName(dBFiledsBF.substring(0, dBFiledsBF.length()-1));
	}
}
