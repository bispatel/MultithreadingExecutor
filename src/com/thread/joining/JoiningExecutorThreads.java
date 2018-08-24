package com.thread.joining;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.thread.common.LoopTaskI;
import com.thread.common.NamedThreadFactory;

public class JoiningExecutorThreads {

	public static void main(String[] args) throws InterruptedException {
		String currentThread = Thread.currentThread().getName();
		System.out.println("["+currentThread+"] Main Thread Starts");
		
		ExecutorService execService = Executors.newCachedThreadPool(new NamedThreadFactory());
		CountDownLatch latch  = new CountDownLatch(4);
		execService.execute(new LoopTaskI(latch));
		execService.execute(new LoopTaskI(latch));
		execService.execute(new LoopTaskI(latch));
		execService.execute(new LoopTaskI(latch));
		
		execService.shutdown();
		
		try {
			latch.await();
			System.out.println("["+currentThread+"] GOT THE SIGNAL TO CONTINUE....");
		}catch(InterruptedException ie) {
			ie.printStackTrace();
		}
		
				
		
		
		System.out.println("["+currentThread+"] Main Thread Ends");
		
	}
}
