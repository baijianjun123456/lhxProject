package com.lhx.file.handler.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lhx.file.copy.context.FileContext;
import com.lhx.file.handler.FileHandler;


public abstract class AbstractFileHandler implements FileHandler {
	
	private static final Logger log = LoggerFactory.getLogger(AbstractFileHandler.class);
	
	@Override
	public void exec(FileContext fileContext,File srcFile_,File descFile_) throws IOException{
		BufferedReader bufferedReader = null;
		PrintWriter destPW = null;
		
		String descFilePath = descFile_.getAbsolutePath().replace("@moduleName@", fileContext.getContextModel().getModuleName());
		descFilePath = descFilePath.replace("@fmoduleName@", fileContext.getContextModel().getFmoduleName()).replace("@","");
		File descFile = new File(descFilePath);
		
		File parentFile =  descFile.getParentFile();
		while(!parentFile.exists()){
			parentFile.mkdir();
			parentFile = parentFile.getParentFile();
		}
		descFile.createNewFile();
		try {
			InputStreamReader srcRead = new InputStreamReader(new FileInputStream(srcFile_),"UTF-8");
			bufferedReader = new BufferedReader(srcRead);
			String lineTxt = null;
			destPW = new PrintWriter(descFile);
	        while((lineTxt = bufferedReader.readLine()) != null){
	        	destPW.println(this.handler(fileContext,lineTxt));
	        }
		} catch (Exception ex) {
			
		} 
		finally{
			if(destPW != null){
				destPW.close();
			}
			if(bufferedReader != null){
				bufferedReader.close();
			}
			
		}
	}
	
	public String handler(FileContext fileContext,String lineText){
		Pattern p =  Pattern.compile("@[0-9a-zA-Z]+@");
		Matcher m = p.matcher(lineText);
		while(m.find()){
			lineText = replaceValue(fileContext,lineText,m.group(0));
		}
		return lineText;
	}
	
	private String replaceValue(FileContext fileContext,String lineText,String patternOld){
		String patternNew = patternOld.replaceAll("@", "");
		String getMethodStr = "get"+patternNew.replaceFirst(patternNew.substring(0, 1), patternNew.substring(0, 1).toUpperCase());
		try {
			Method getmethod = fileContext.getContextModel().getClass().getDeclaredMethod(getMethodStr,new Class<?>[]{});
			Object invokeValue = getmethod.invoke(fileContext.getContextModel());
			if(invokeValue != null){
				lineText = lineText.replaceAll(patternOld,invokeValue.toString());
			}
		} catch (Exception ex) {
			log.error("调用"+getMethodStr+"失败！", ex);
		}
		return lineText;
	}

}
