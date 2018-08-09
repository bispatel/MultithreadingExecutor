package com.thread.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.thread.common.LoopTaskC;
import com.thread.common.NamedThreadFactory;

public class NamingExecutorService {
	public static void main(String[] args) {
		String currentThreadName = Thread.currentThread().getName();
		System.out.println("[" + currentThreadName + "] thread starts here..");
		ExecutorService ex =Executors.newCachedThreadPool(new NamedThreadFactory());
		ex.execute(new LoopTaskC());
		ex.execute(new LoopTaskC());
		ex.execute(new LoopTaskC());
		ex.execute(new LoopTaskC());
		System.out.println("[" + currentThreadName + "] thread ended.");
	}
}
