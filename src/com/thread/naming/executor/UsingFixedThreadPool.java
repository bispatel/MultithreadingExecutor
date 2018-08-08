package com.thread.naming.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.thread.common.LoopTaskA;

public class UsingFixedThreadPool {

	public static void main(String[] args) {

		String currentThreadName =Thread.currentThread().getName();
		System.out.println("["+currentThreadName+ "] thread starts here..");
		ExecutorService exec =Executors.newFixedThreadPool(3); 
		exec.execute(new LoopTaskA());
		exec.execute(new LoopTaskA());
		exec.execute(new LoopTaskA());
		
		exec.execute(new LoopTaskA());
		exec.execute(new LoopTaskA());
		exec.execute(new LoopTaskA());
		exec.execute(new LoopTaskA());
		exec.shutdown(); 
		System.out.println("["+currentThreadName+ "] thread ended.");
	
	}

}
