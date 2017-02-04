package com.sample.logger;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sample.logger.requestid.RequestIdGenerator;

public class MyLogger {
	
	private static final String REQUEST_ID = "requestid";

    private Logger logger;

   
    
    @SuppressWarnings("rawtypes")
	public MyLogger(Class clazz) {
        this.logger = LoggerFactory.getLogger(clazz.getName());
    }
    
    public void info(String str){
    	logger.info(REQUEST_ID + ": " + RequestIdGenerator.getRequestId() + " : " + str);
    }
    
    public void info(Object str){
    	logger.info(REQUEST_ID + ": " + RequestIdGenerator.getRequestId() + " : " + str.toString());
    }
    
    public void debug(String str){
    	this.info(REQUEST_ID + ": " + RequestIdGenerator.getRequestId() + " : " + str);
    }
    
    public void error(String str){
    	logger.info(REQUEST_ID + ": " + RequestIdGenerator.getRequestId() + " : " + str);
    }
    
}