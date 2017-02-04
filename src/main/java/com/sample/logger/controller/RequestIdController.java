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

import com.sample.helper.MyCallableTask;
import com.sample.helper.MyRunnableTask;
import com.sample.logger.MyLogger;

@RestController
public class RequestIdController {
	
	private MyLogger logger = new MyLogger(RequestIdController.class);
	private ExecutorService executor = Executors.newFixedThreadPool(5);
		
	@RequestMapping(value="/requestid", method = RequestMethod.GET)
	public String requestId() {
		
		logger.info("in RequestId controller");
		
		List<Future<String>> furturesList = new ArrayList<Future<String>>();
	
		for(int i=0; i<10; i++){
			MyCallableTask task = new MyCallableTask();
			furturesList.add(executor.submit(task));
			logger.info("submitted callable task :  " + task.toString());
		}
		logger.info("submitted all callable tasks ");
		
		
		for(int i=0; i<4; i++){
			MyRunnableTask runnable = new MyRunnableTask();
			executor.execute(runnable);
			logger.info("submitted runnbale task :  " + runnable.toString());
		}
		
		
		logger.info("submitted all runnable tasks");
		
		logger.info("Started fetching callable task return values");
		
		for(Future<String> future : furturesList){
			try {
				logger.info(future.get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
		
		logger.info("Done fetching callable task return values");
		
		return "done";
	}
}
