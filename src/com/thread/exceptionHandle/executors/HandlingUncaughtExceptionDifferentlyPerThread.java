package com.thread.exceptionHandle.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.thread.common.ExceptionLeakingTask;
import com.thread.common.ThreadFactoryWithExceptionHandler;

public class HandlingUncaughtExceptionDifferentlyPerThread {

	public static void main(String[] args) {
		String currentThreadName = Thread.currentThread().getName();
		System.out.println("[" + currentThreadName + "] thread starts here..");

		ExecutorService execService1 = Executors.newCachedThreadPool(new ThreadFactoryWithExceptionHandler());
		execService1.execute(new ExceptionLeakingTask());
		execService1.execute(new ExceptionLeakingTask());
		execService1.execute(new ExceptionLeakingTask());
		execService1.execute(new ExceptionLeakingTask());

		execService1.shutdown();

		System.out.println("[" + currentThreadName + "] thread ended.");
	}

}
