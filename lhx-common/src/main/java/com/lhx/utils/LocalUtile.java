package com.lhx.utils;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class LocalUtile {
	
	public static Map<String,String> getLocal(){
		Map<String,String> localMap = new HashMap<String,String>();
		localMap.put("i18n", Locale.getDefault().toString());
		return localMap;
	}

}
