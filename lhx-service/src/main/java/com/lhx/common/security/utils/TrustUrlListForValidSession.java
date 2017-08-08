package com.lhx.common.security.utils;

import java.util.ArrayList;
import java.util.List;

public class TrustUrlListForValidSession {
	
	private static List<String> trustList = new ArrayList<String>();
	
	public static List<String> getTrustList() {
		return trustList;
	}

	public  void setTrustList(List<String> trustList) {
		TrustUrlListForValidSession.trustList = trustList;
	}

	public static boolean isTrust(String url){
		for(String trustUrl : trustList){
			if(trustUrl.indexOf(url) != -1){
				return true;
			}
		}
		return false;
	}
	
}
