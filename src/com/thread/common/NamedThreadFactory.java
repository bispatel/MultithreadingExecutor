package com.thread.common;

import java.util.concurrent.ThreadFactory;

public class NamedThreadFactory implements ThreadFactory {

	private static int count = 0;

	@Override
	public Thread newThread(Runnable r) {
		Thread t = new Thread(r, "ExecutorThread" + (++count));
		return t;
	}

}
