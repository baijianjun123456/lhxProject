package com.lhx.file.copy.context;

import java.io.File;

import com.lhx.file.model.ContextModel;
import com.lhx.utils.PropertiesUtils;

public class DaoFileContext extends FileContext{
	
	private static final String SRC_MKDIR_DAO = "SRC_MKDIR_DAO_PATH";
	
	private static final String DESC_MKDIR_DAO = "DESC_MKDIR_DAO_PATH";
	
	private static final String DAO_PROJECT_NAME = "DAO_PROJECT_NAME";

	public static DaoFileContext newInstance(ContextModel contextModel_){	
		return new DaoFileContext(contextModel_);
	}
	
	private DaoFileContext(ContextModel contextModel_){
		super.contextModel = contextModel_;
		super.SRC_MKDIR_PATH = PropertiesUtils.getProperties(SRC_MKDIR_DAO);
		super.DESC_MKDIR_PATH =PropertiesUtils.getProperties(DESC_MKDIR_DAO);
		super.projectName =PropertiesUtils.getProperties(DAO_PROJECT_NAME);
	}
	
	public String getDescFilePath(File srcFile,String basePath){
	
		String srcModulePath = srcFile.getAbsolutePath().replace(BASE_PATH+SRC_MKDIR_PATH, "");
		
		String descFile =BASE_PATH.replace("lhx-persistence", projectName)+DESC_MKDIR_PATH+contextModel.getClassBusPath().replace(".", "\\\\")+"\\"+srcModulePath;
		
		return descFile;
	}

}
