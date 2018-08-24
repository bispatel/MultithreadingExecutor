package com.thread.terminate.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import com.thread.common.FactorialTaskB;
import com.thread.common.LoopTaskA;
import com.thread.common.LoopTaskG;
import com.thread.common.NamedThreadFactory;

public class TerminatingBlockedExecutor {

	public static void main(String[] args) throws InterruptedException {
		String currentThreadName = Thread.currentThread().getName();
		System.out.println("[" + currentThreadName + "] thread starts here..");

		ExecutorService execService = Executors.newCachedThreadPool(new NamedThreadFactory());

		LoopTaskA t1 = new LoopTaskA();
		LoopTaskG t2 = new LoopTaskG();
		FactorialTaskB t3 = new FactorialTaskB(30, 500);

		Future<?> f1 = execService.submit(t1);
		Future<?> f2 = execService.submit(t2);
		Future<?> f3 = execService.submit(t3);

		execService.shutdown();

		TimeUnit.MILLISECONDS.sleep(300);

		System.out.println("[" + currentThreadName + "] Invoking Cancel method on all the task ....");
		f1.cancel(true);
		f2.cancel(true);
		f3.cancel(true);

		System.out.println("[" + currentThreadName + "] thread ended.");

	}
}
