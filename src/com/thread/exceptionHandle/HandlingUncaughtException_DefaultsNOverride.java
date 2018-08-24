package com.thread.exceptionHandle;

import com.thread.common.ExceptionLeakingTask;
import com.thread.common.ThreadExceptionHandler;

public class HandlingUncaughtException_DefaultsNOverride {

	public static void main(String[] args) {
		String currentThreadName = Thread.currentThread().getName();

		System.out.println("[" + currentThreadName + "] thread starts here..");
		Thread.setDefaultUncaughtExceptionHandler(new ThreadExceptionHandler("DAFAULT-HANDLER"));

		Thread t1 = new Thread(new ExceptionLeakingTask(), "MyThread-1");
		
		Thread t2 = new Thread(new ExceptionLeakingTask(), "MyThread-2");
		t2.setUncaughtExceptionHandler(new ThreadExceptionHandler("Custom_Handler_1"));

		
		Thread t3 = new Thread(new ExceptionLeakingTask(), "MyThread-3");

		
		Thread t4 = new Thread(new ExceptionLeakingTask(), "MyThread-4");
		t4.setUncaughtExceptionHandler(new ThreadExceptionHandler("Custom_Handler_2"));

		t1.start();
		t2.start();
		t3.start();
		t4.start();
		 

		System.out.println("[" + currentThreadName + "] thread ended.");
	}

}
