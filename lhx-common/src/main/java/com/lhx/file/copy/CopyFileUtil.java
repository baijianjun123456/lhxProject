package com.lhx.file.copy;

import java.io.IOException;

import com.lhx.file.copy.context.DaoFileContext;
import com.lhx.file.copy.context.ServiceFileContext;
import com.lhx.file.copy.context.WebFileContext;
import com.lhx.file.model.ContextModel;

/**
 * copy文件工具类；
 * @author liangshu
 *
 */
public class CopyFileUtil {
		
	/**
	 * copy文件；
	 * @param contextModel ：文件copy项目属性模型对象；
	 * @throws IOException
	 */
	public static void copy(ContextModel contextModel,boolean isDao,boolean isService,boolean isWeb) throws IOException{
		if(isDao){
			copyDao(contextModel);
		}
		
		if(isService){
			copyService(contextModel);		
		}
		
		if(isWeb){
			copyWeb(contextModel);
		}
	}
	
	public static void copyDao(ContextModel contextModel) throws IOException{
		DaoFileContext.newInstance(contextModel).copy();
	}
	
	public static void copyService(ContextModel contextModel) throws IOException{
		ServiceFileContext.newInstance(contextModel).copy();
	}
	
	public static void copyWeb(ContextModel contextModel) throws IOException{
		WebFileContext.newInstance(contextModel).copy();
	}
}
