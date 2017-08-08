package com.lhx.common.mybatis.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lhx.file.model.ContextModel;
import com.lhx.file.model.TabColModel;

/**
 * 表列转换工具类；
 * @author liangshu
 *
 */
public class TabColCovertUtil {
	
	
	
	/**
	 * 将表的列信息转换成MAP，key：列名，value:列数据类型；
	 * @param tabColList
	 * @return
	 */
	public static void cortMap(ContextModel contextModel,List<TabColModel> tabColList){
		Map<String,String> tabColMap = new HashMap<String,String>();
		for(TabColModel tabColModel : tabColList){
			String column_name = tabColModel.getColumnName();
			String dataType = tabColModel.getDBDataType();
			tabColMap.put(column_name, dataType);
		}
		contextModel.setdBFileds(tabColMap);
	}
}
