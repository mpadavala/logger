package com.sample.logger.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sample.logger.MyCallableTask;
import com.sample.logger.MyLogger;
import com.sample.logger.MyRunnableTask;

@RestController
public class RequestIdController {
	
	private MyLogger logger = new MyLogger(RequestIdController.class);
			
	@RequestMapping(value="/requestid", method = RequestMethod.GET)
	public String requestId() {
		
		ExecutorService executor = Executors.newFixedThreadPool(5);
		 
		logger.info("in requestid controller");
		
		List<Future<String>> furturesList = new ArrayList<Future<String>>();
		
		for(int i=0; i<3; i++){
			MyCallableTask task = new MyCallableTask();
			furturesList.add(executor.submit(task));
		}
		logger.info("submitted all future tasks (callables)");
		
		for(int i=0; i<4; i++){
			MyRunnableTask thread = new MyRunnableTask();
			executor.execute(thread);
		}
		
		
		logger.info("submitted all Runnable tasks (Runnbales)");
		
		logger.info("Started to fetch callable task return values");
		
		for(Future<String> future : furturesList){
			try {
				logger.info(future.get());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		logger.info("Done fetching callable task return values");
		
		return "done";
	}
}
