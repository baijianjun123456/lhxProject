package com.lhx.file.copy.context;

import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.core.util.ArrayUtils;

import com.lhx.file.copy.FileCopyImp;
import com.lhx.file.copy.MkdirCopyImp;
import com.lhx.file.model.ContextModel;
import com.lhx.utils.PropertiesUtils;

public abstract class FileContext {
	
   static final String BASE_PATH = System.getProperty("user.dir");
	
	String SRC_MKDIR_PATH = "";
	
	String DESC_MKDIR_PATH = "";
	
	String projectName = "";

	ContextModel contextModel;
	
	public void copy() throws IOException{
		File baseSrcFile = new File(BASE_PATH+SRC_MKDIR_PATH);
		this.copy(baseSrcFile);
	}
	
	private void copy(File baseSrcFile) throws IOException{
		File[] srcFiles = baseSrcFile.listFiles();
		if(ArrayUtils.getLength(srcFiles) != 0){
			for(File srcFile : srcFiles){
				
				
				//String srcModulePath = srcFile.getAbsolutePath().replace(BASE_PATH+SRC_MKDIR_PATH, "");
				
				//File descFile = new File(BASE_PATH+DESC_MKDIR_PATH+contextModel.getClassBusPath().replace(".", "\\\\")+"\\"+srcModulePath);
				
				String descFilePath = getDescFilePath(srcFile,BASE_PATH);
				
				File descFile = new File(descFilePath);
				
				if(srcFile.isDirectory()){
					new MkdirCopyImp(this).copy(descFile);
					this.copy(srcFile);
				}
				else{
					new FileCopyImp(this).copy(srcFile, descFile);
				}
			}
		}
	}
	
	public abstract String getDescFilePath(File srcFile,String basePath);
	
	public ContextModel getContextModel() {
		return contextModel;
	}

	public void setContextModel(ContextModel contextModel) {
		this.contextModel = contextModel;
	}
	
	static{
		PropertiesUtils.load("com\\lhx\\file\\copy\\CopyFile.properties");
	}
	
	
	public String getFileType(String fileName){
		String fileType = fileName.split("\\.")[1].toUpperCase().replace("@", "");
		return fileType;
	}


}
