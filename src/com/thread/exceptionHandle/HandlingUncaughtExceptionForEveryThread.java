package com.thread.exceptionHandle;

import com.thread.common.ExceptionLeakingTask;
import com.thread.common.ThreadExceptionHandler;

public class HandlingUncaughtExceptionForEveryThread {

	public static void main(String[] args) {
		String currentThreadName = Thread.currentThread().getName();

		System.out.println("[" + currentThreadName + "] thread starts here..");
		Thread.setDefaultUncaughtExceptionHandler(new ThreadExceptionHandler("DAFAULT-HANDLER"));

		new Thread(new ExceptionLeakingTask(), "MyThread-1").start();
		new Thread(new ExceptionLeakingTask(), "MyThread-2").start();
		new Thread(new ExceptionLeakingTask(), "MyThread-3").start();
		new Thread(new ExceptionLeakingTask(), "MyThread-4").start();

		System.out.println("[" + currentThreadName + "] thread ended.");
	}

}
