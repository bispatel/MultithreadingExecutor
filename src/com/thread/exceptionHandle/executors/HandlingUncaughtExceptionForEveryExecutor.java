package com.thread.exceptionHandle.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.thread.common.ExceptionLeakingTask;
import com.thread.common.ThreadExceptionHandler;

public class HandlingUncaughtExceptionForEveryExecutor {

	public static void main(String[] args) {
		String currentThreadName = Thread.currentThread().getName();
		System.out.println("[" + currentThreadName + "] thread starts here..");
		
		Thread.setDefaultUncaughtExceptionHandler(new ThreadExceptionHandler("DEFAULT-EXCEPTION-HANDLER"));
		ExecutorService execService1 = Executors.newCachedThreadPool();
		execService1.execute(new ExceptionLeakingTask());
		execService1.execute(new ExceptionLeakingTask());
		execService1.execute(new ExceptionLeakingTask());
		

		ExecutorService execService2 = Executors.newCachedThreadPool();
		execService2.execute(new ExceptionLeakingTask());
		execService2.execute(new ExceptionLeakingTask());
		execService2.execute(new ExceptionLeakingTask());
		
		execService1.shutdown();
		execService2.shutdown();
		
		System.out.println("[" + currentThreadName + "] thread ended.");
	}

}
