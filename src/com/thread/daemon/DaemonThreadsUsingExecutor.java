package com.thread.daemon;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.thread.common.DaemonThreadFactory;
import com.thread.common.LoopTaskD;

public class DaemonThreadsUsingExecutor {
	public static void main(String[] args) {

		String currentThreadName = Thread.currentThread().getName();
		System.out.println("[" + currentThreadName + "] thread starts here..");
		ExecutorService exec =  Executors.newCachedThreadPool(new DaemonThreadFactory());
		exec.execute(new LoopTaskD(100));
		exec.execute(new LoopTaskD(200));
		exec.execute(new LoopTaskD(300));
		exec.execute(new LoopTaskD(400));
		exec.shutdown();
		
		System.out.println("[" + currentThreadName + "] thread ended.");

	}
}

