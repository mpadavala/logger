package com.sample.logger;

import java.util.logging.Logger;

import com.sample.logger.requestid.RequestIdGenerator;

public class MyLogger {
	
	private static final String REQUEST_ID = "requestid";

    private Logger logger;

    public MyLogger(String name) {
        this.logger = Logger.getLogger(name);
    }
    
    public MyLogger(Class clazz) {
        this(clazz.getName());
    }
    
    public void info(String str){
    	logger.info(REQUEST_ID + ": " + RequestIdGenerator.getRequestId() + " : " + str);
    }
    
    public void info(Object str){
    	logger.info(REQUEST_ID + ": " + RequestIdGenerator.getRequestId() + " : " + str.toString());
    }
     
    //TO CHANGE THE METHODS PROPERLY
    
    public void debug(String str){
    	this.info(REQUEST_ID + ": " + RequestIdGenerator.getRequestId() + " : " + str);
    }
    
    public void error(String str){
    	logger.info(REQUEST_ID + ": " + RequestIdGenerator.getRequestId() + " : " + str);
    }
    
}