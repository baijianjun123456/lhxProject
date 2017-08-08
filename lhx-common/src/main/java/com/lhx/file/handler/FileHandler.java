package com.lhx.file.handler;

import java.io.File;
import java.io.IOException;

import com.lhx.file.copy.context.FileContext;

public interface FileHandler {
	
	public void exec(FileContext fileContext,File srcFile,File descFile) throws IOException;
	
	public abstract String handler(FileContext fileContext, String lineText);
	
}
