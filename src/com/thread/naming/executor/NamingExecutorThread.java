package com.thread.naming.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.thread.common.LoopTaskC;
import com.thread.common.NamingThreadFactory;

public class NamingExecutorThread {

	public static void main(String[] args) {
		String currentThreadName =Thread.currentThread().getName();
		System.out.println("["+currentThreadName+ "] thread starts here..");
		ExecutorService exec =Executors.newCachedThreadPool(new NamingThreadFactory()); 
		exec.execute(new LoopTaskC());
		exec.execute(new LoopTaskC());
		exec.execute(new LoopTaskC());
		System.out.println("["+currentThreadName+ "] thread ended.");
	}
}
