package com.sample.logger;

import java.util.concurrent.Callable;

import com.sample.logger.requestid.RequestIdGenerator;

public class MyCallableTask implements Callable<String>{
	
	private MyLogger logger = new MyLogger(MyCallableTask.class);
	
	@Override
	public String call() throws Exception {
		
		RequestIdGenerator.setRequestId();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		logger.info("in call() - callable thread id : " + Thread.currentThread().getId());
		
		return "Returned Value from callable.call()";
	}
	

}
