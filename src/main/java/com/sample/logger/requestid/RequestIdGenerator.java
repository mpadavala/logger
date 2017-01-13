package com.sample.logger.requestid;

import java.util.UUID;

public class RequestIdGenerator {

	private static final InheritableThreadLocal<String> requestId = new InheritableThreadLocal<String>();

	public static String getRequestId() {
		return requestId.get();
	}

	public static void setRequestId() {
		if(requestId.get()== null || requestId.get().length() ==0){
			requestId.set(UUID.randomUUID().toString());
		}
	}

	public static void clearRequestId() {
		requestId.remove();
	}

}
