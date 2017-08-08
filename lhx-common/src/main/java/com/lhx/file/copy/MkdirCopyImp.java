package com.lhx.file.copy;

import java.io.File;
import java.io.IOException;

import com.lhx.file.copy.context.FileContext;

public class MkdirCopyImp {
	
	@SuppressWarnings("unused")
	private FileContext fileContext;
	
	public MkdirCopyImp(FileContext fileContext_){
		this.fileContext = fileContext_;
	}
	
	public  File copy(File descFile) throws IOException{
		if(!descFile.exists()){
			descFile.mkdirs();
		}
		return descFile;
	}

}
