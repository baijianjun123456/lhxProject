package com.lhx.file.copy.context;

import java.io.File;

import com.lhx.file.model.ContextModel;
import com.lhx.utils.PropertiesUtils;

public class WebFileContext extends FileContext{
	
	private static final String SRC_MKDIR_WEB = "SRC_MKDIR_WEB_PATH";
	
	private static final String DESC_MKDIR_WEB = "DESC_MKDIR_WEB_PATH";
	
	private static final String WEB_PROJECT_NAME = "WEB_PROJECT_NAME";

	public static WebFileContext newInstance(ContextModel contextModel_){	
		return new WebFileContext(contextModel_);
	}
	
	private WebFileContext(ContextModel contextModel_){
		super.contextModel = contextModel_;
		super.SRC_MKDIR_PATH = PropertiesUtils.getProperties(SRC_MKDIR_WEB);
		super.DESC_MKDIR_PATH =PropertiesUtils.getProperties(DESC_MKDIR_WEB);
		super.projectName =PropertiesUtils.getProperties(WEB_PROJECT_NAME);
	}
	
	public String getDescFilePath(File srcFile,String basePath){
		basePath = basePath.substring(0, basePath.lastIndexOf("\\"))+"\\"+super.projectName;
		String srcModulePath = srcFile.getAbsolutePath().replace(BASE_PATH+SRC_MKDIR_PATH, "");
		
		String descFile = "";

		descFile =basePath+DESC_MKDIR_PATH+contextModel.getClassBusPath().split("\\.")[0]+"\\"+srcModulePath;
		
		if(!srcFile.isDirectory()){
			String fileType = super.getFileType(srcModulePath);
			if("JS".equals(fileType) || "JSP".equals(fileType)){
				descFile = basePath+DESC_MKDIR_PATH+contextModel.getClassBusPath().replace(".", "\\")+"\\"+srcModulePath;
				descFile = descFile.replace("\\java\\com\\lhx\\", "\\webapp\\");
				descFile = descFile.replace("\\jsp", "\\");
			}
			else{
				descFile = basePath+DESC_MKDIR_PATH+contextModel.getClassBusPath().split("\\.")[0]+"\\"+srcModulePath;

			}
		}
		
		if(srcFile.isDirectory()){
			descFile =basePath+DESC_MKDIR_PATH+contextModel.getClassBusPath().replace(".", "\\")+"\\"+srcModulePath;
			descFile = descFile.replace("\\java\\com\\lhx\\", "\\webapp\\");
		}

		return descFile;
	}

	
}

