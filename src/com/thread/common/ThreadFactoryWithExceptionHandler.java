package com.thread.common;

public class ThreadFactoryWithExceptionHandler extends NamedThreadFactory {
	public Thread newThread(Runnable r) {
		Thread t = super.newThread(r);
		t.setUncaughtExceptionHandler(new ThreadExceptionHandler());
		return t;
	}
}
