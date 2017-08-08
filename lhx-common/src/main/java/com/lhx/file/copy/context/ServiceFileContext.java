package com.lhx.file.copy.context;

import java.io.File;

import com.lhx.file.model.ContextModel;
import com.lhx.utils.PropertiesUtils;

public class ServiceFileContext extends FileContext{
	
	private static final String SRC_MKDIR_SERVICE = "SRC_MKDIR_SERVICE_PATH";
	
	private static final String DESC_MKDIR_SERVICE = "DESC_MKDIR_SERVICE_PATH";
	
	private static final String SERVICE_PROJECT_NAME = "SERVICE_PROJECT_NAME";

	public static ServiceFileContext newInstance(ContextModel contextModel_){	
		return new ServiceFileContext(contextModel_);
	}
	
	private ServiceFileContext(ContextModel contextModel_){
		super.contextModel = contextModel_;
		super.SRC_MKDIR_PATH = PropertiesUtils.getProperties(SRC_MKDIR_SERVICE);
		super.DESC_MKDIR_PATH =PropertiesUtils.getProperties(DESC_MKDIR_SERVICE);
		super.projectName =PropertiesUtils.getProperties(SERVICE_PROJECT_NAME);
	}
	
	public String getDescFilePath(File srcFile,String basePath){
		basePath = basePath.substring(0, basePath.lastIndexOf("\\"))+"\\"+super.projectName;
		String srcModulePath = srcFile.getAbsolutePath().replace(BASE_PATH+SRC_MKDIR_PATH, "");
		
		String descFile =basePath+DESC_MKDIR_PATH+contextModel.getClassBusPath().split("\\.")[0]+"\\service\\"+srcModulePath;
		
		return descFile;
	}

	
}
