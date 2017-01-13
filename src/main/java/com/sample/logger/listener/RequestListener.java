package com.sample.logger.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

import com.sample.logger.MyLogger;
import com.sample.logger.requestid.RequestIdGenerator;

public class RequestListener implements ServletRequestListener { 

	private static MyLogger logger = new MyLogger(RequestListener.class.getName());
	
	
	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		HttpServletRequest request = (HttpServletRequest)sre.getServletRequest();
		RequestIdGenerator.setRequestId();
		logger.info("RequestURL : " +  request.getRequestURL() + " - " +  request.getHeader("referer"));
	}
	
	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		HttpServletRequest request = (HttpServletRequest)sre.getServletRequest();
		logger.info("RequestDestroyed: " +  request.getRequestURL() + " - " +  request.getHeader("referer")); 
		RequestIdGenerator.clearRequestId();
	}
}
