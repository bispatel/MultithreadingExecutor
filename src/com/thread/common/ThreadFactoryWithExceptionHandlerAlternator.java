package com.thread.common;

public class ThreadFactoryWithExceptionHandlerAlternator extends NamedThreadFactory {
	private int count = 0;

	public Thread newThread(Runnable r) {
		Thread t = super.newThread(r);
		int sequencenumber = ++count;
		if (sequencenumber % 2 == 0) {
			t.setUncaughtExceptionHandler(new ThreadExceptionHandler());
		}

		return t;
	}
}
