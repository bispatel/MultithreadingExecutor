package com.thread.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.thread.common.LoopTaskA;

public class UsingFixedThreadPool {
	public static void main(String[] args) {
		String currentThreadName = Thread.currentThread().getName();
		System.out.println("[" + currentThreadName + "] thread starts here..");
		ExecutorService ex = Executors
				.newFixedThreadPool(12);
		ex.execute(new LoopTaskA());
		ex.execute(new LoopTaskA());
		ex.execute(new LoopTaskA());
		ex.execute(new LoopTaskA());
		ex.execute(new LoopTaskA());
		ex.execute(new LoopTaskA());
		ex.execute(new LoopTaskA());
		ex.execute(new LoopTaskA());
		ex.execute(new LoopTaskA());
		ex.execute(new LoopTaskA());
		ex.execute(new LoopTaskA());
		ex.execute(new LoopTaskA());
		ex.shutdown();
		System.out.println("[" + currentThreadName + "] thread ended.");
	}
}
