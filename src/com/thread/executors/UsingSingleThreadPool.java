package com.thread.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.thread.common.LoopTaskA;
import com.thread.common.NamedThreadFactory;

public class UsingSingleThreadPool {
	public static void main(String[] args) throws InterruptedException {
		String currentThreadName = Thread.currentThread().getName();
		System.out.println("[" + currentThreadName + "] thread starts here..");
		ExecutorService ex = Executors
				.newSingleThreadExecutor(new NamedThreadFactory());
		ex.execute(new LoopTaskA());
		ex.execute(new LoopTaskA());
		ex.execute(new LoopTaskA());

		ex.shutdown();
		System.out.println("[" + currentThreadName + "] thread ended.");
	}
}
