package com.lhx.file.copy;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lhx.file.copy.context.FileContext;
import com.lhx.file.handler.FileHandler;
import com.lhx.utils.PropertiesUtils;

public class FileCopyImp {
	
	private static final Logger log = LoggerFactory.getLogger(FileCopyImp.class);

	public static final Map<String,FileHandler> handlerMap = new HashMap<String,FileHandler>();
	
	private static final String FILE_HANDLER_CLASS = "FILE_HANDLER_CLASS_";
	
	private FileContext fileContext;
	
	public FileCopyImp(FileContext fileContext_){
		this.fileContext = fileContext_;
	}

	public  void copy(File srcFile,File descFile){
		
		String fileName = srcFile.getName();
		String fileType = fileName.split("\\.")[1].toUpperCase().replace("@", "");
		try {
			this.getHandler(fileType).exec(fileContext,srcFile,descFile);
		} catch (Exception ex) {
			log.error("获取"+fileType+"文件处copy处理器失败！", ex.getMessage());
		} 

	}
	
	private FileHandler getHandler(String fileType) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return (FileHandler)Class.forName(PropertiesUtils.getProperties(FILE_HANDLER_CLASS+fileType)).newInstance();
	}
}
