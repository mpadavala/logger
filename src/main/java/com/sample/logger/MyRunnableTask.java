package com.sample.logger;

public class MyRunnableTask implements Runnable {

	private MyLogger logger = new MyLogger(MyRunnableTask.class);
	
	@Override
	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		logger.info("in run() - runnable thread id : " + Thread.currentThread().getId());
	}
}
