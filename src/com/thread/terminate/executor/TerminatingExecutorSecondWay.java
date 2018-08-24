package com.thread.terminate.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import com.thread.common.CallableTaskC;
import com.thread.common.LoopTaskF;
import com.thread.common.NamedThreadFactory;

public class TerminatingExecutorSecondWay {

	public static void main(String[] args) throws InterruptedException {
		String currentThreadName = Thread.currentThread().getName();
		System.out.println("[" + currentThreadName + "] thread starts here..");

		ExecutorService execService = Executors.newCachedThreadPool(new NamedThreadFactory());

		CallableTaskC t1 = new CallableTaskC();
		LoopTaskF t2 = new LoopTaskF();

		Future<Long> f1 = execService.submit(t1);
		Future<?> f2 = execService.submit(t2);

		execService.shutdown();

		TimeUnit.MILLISECONDS.sleep(300);
		
		System.out.println("["+currentThreadName+"] Interrupting 'CalculationTaskC-1' ....");
		f1.cancel(true);
		
		System.out.println("["+currentThreadName+"] Interrupting 'LoopTaskF-1' ....");
		f2.cancel(true);
		

		System.out.println("[" + currentThreadName + "] thread ended.");

	}
}
