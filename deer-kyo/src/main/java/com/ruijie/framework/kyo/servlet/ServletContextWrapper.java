package com.ruijie.framework.kyo.servlet;

import javax.servlet.ServletContext;

public class ServletContextWrapper { 
	
	/**
	 * WEB容器在启动时，它会为每个WEB应用程序都创建一个对应的ServletContext对象，它代表当前web应用
	 *  由于一个WEB应用中的所有Servlet共享同一个ServletContext对象，
	 *  因此Servlet对象之间可以通过ServletContext对象来实现通讯
	 *  
	 */
    private static ServletContext servletContext;
    
    private static boolean isLock = false;
    
    public static void setServletContext(ServletContext context) {
    	if(isLock) {
    		return;
    	}
    	servletContext = context;
    	isLock = true;
    }
    
    public static ServletContext getServletContext() {
    	return ServletContextWrapper.servletContext;
    }
}
