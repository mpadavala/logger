package com.sample.logger.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

import com.sample.logger.MyLogger;
import com.sample.logger.requestid.RequestIdGenerator;

public class RequestListener implements ServletRequestListener { 

	private static MyLogger logger = new MyLogger(RequestListener.class.getName());
	private static final String REQUEST_ID = "requestid";
	
	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		HttpServletRequest request = (HttpServletRequest)sre.getServletRequest();
		RequestIdGenerator.setRequestId();
		logger.info("Request Initialized - URL : " +  request.getRequestURL() + " - " +  request.getHeader("referer")); 
		
		logger.info("Request Id : " + RequestIdGenerator.getRequestId());
		
	}
	
	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		HttpServletRequest request = (HttpServletRequest)sre.getServletRequest();
		logger.info("Request Destroyed - URL : " +  request.getRequestURL() + " - " +  request.getHeader("referer")); 
		logger.info("Request Id : " + request.getAttribute(REQUEST_ID));
		RequestIdGenerator.clearRequestId();
	}
}
