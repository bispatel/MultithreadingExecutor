package com.thread.terminate.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.thread.common.FactorialTaskA;
import com.thread.common.LoopTaskE;
import com.thread.common.NamedThreadFactory;

public class TerminatingExecutorFirstWay {

	public static void main(String[] args) throws InterruptedException {
		String currentThreadName = Thread.currentThread().getName();
		System.out.println("[" + currentThreadName + "] thread starts here..");

		ExecutorService execService = Executors.newCachedThreadPool(new NamedThreadFactory());
		LoopTaskE t1 = new LoopTaskE();
		FactorialTaskA t2 = new FactorialTaskA(30, 100);
		execService.execute(t1);
		execService.submit(t2);
		execService.shutdown();

		TimeUnit.MILLISECONDS.sleep(300);
		t1.cancel();
		t2.cancel();

		System.out.println("[" + currentThreadName + "] thread ended.");

	}
}
