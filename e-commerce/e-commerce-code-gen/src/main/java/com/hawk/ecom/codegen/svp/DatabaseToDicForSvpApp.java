package com.hawk.ecom.codegen.svp;

import com.hawk.framework.codegen.database.DatabaseToDicService;

/**
 * 从数据库生成数据字典
 * @author pzhang1
 *
 */
public class DatabaseToDicForSvpApp {
	
	public static void main(String[] args){
		try {
			new DatabaseToDicService().execute("com.hawk.ecom.codegen.svp");
		} catch (Throwable e) {
			e.printStackTrace();
		}finally{
			System.exit(0);
		}
	}

}
