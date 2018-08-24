package com.thread.exceptionHandle.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.thread.common.ExceptionLeakingTask;
import com.thread.common.ThreadExceptionHandler;
import com.thread.common.ThreadFactoryWithExceptionHandlerAlternator;

public class HandlingUncaughtException_DefaultsNOverride {

	public static void main(String[] args) {
		String currentThreadName = Thread.currentThread().getName();

		System.out.println("[" + currentThreadName + "] thread starts here..");
		Thread.setDefaultUncaughtExceptionHandler(new ThreadExceptionHandler("DAFAULT-HANDLER"));

		ExecutorService execService = Executors.newCachedThreadPool(new ThreadFactoryWithExceptionHandlerAlternator());
		execService.execute(new ExceptionLeakingTask());
		execService.execute(new ExceptionLeakingTask());
		execService.execute(new ExceptionLeakingTask());
		execService.execute(new ExceptionLeakingTask());
		execService.execute(new ExceptionLeakingTask());
		
		execService.shutdown();

		System.out.println("[" + currentThreadName + "] thread ended.");
	}

}
