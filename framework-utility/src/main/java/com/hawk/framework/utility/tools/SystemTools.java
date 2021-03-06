package com.hawk.framework.utility.tools;

public class SystemTools {
	
	/**
	 * 
	 * @return 获取当前环境的cpu数
	 */
	public int cpuAmount(){
		return Runtime.getRuntime().availableProcessors();
	}
	
	/**
	 * Registers a new virtual-machine shutdown hook
	 * 注册一个在jvm关闭时触发运行的钩子
	 */
	public void hookJvmShutdown(Runnable hook){
		Runtime.getRuntime().addShutdownHook(new Thread(hook));
	}
	
	/**
	 * 
	 * @return 操作系统名称
	 */
	public String operatingSystem(){
		return System.getProperty("os.name");
	}

}
