package com.thread.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.thread.common.LoopTaskA;
import com.thread.common.NamedThreadFactory;

public class UsingCachedThreadPool {
	public static void main(String[] args) throws InterruptedException {
		String currentThreadName = Thread.currentThread().getName();
		System.out.println("[" + currentThreadName + "] thread starts here..");
		ExecutorService ex = Executors
				.newCachedThreadPool(new NamedThreadFactory());
		ex.execute(new LoopTaskA());
		ex.execute(new LoopTaskA());
		ex.execute(new LoopTaskA());
		ex.execute(new LoopTaskA());
		
		Thread.sleep(1000);
		
		ex.execute(new LoopTaskA());
		ex.execute(new LoopTaskA());
		ex.execute(new LoopTaskA());
		ex.execute(new LoopTaskA());
		
		ex.shutdown();
		System.out.println("[" + currentThreadName + "] thread ended.");
	}
}
