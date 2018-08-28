package com.thread.scheduling.executors;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import com.thread.common.CallableTaskD;
import com.thread.common.NamedThreadFactory;
import com.thread.common.ScheduledTaskB;

public class SchedulingTaskForOneTimeExecUsingExecutor {
	private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss.SSS");

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		String currentThread = Thread.currentThread().getName();
		System.out.println("[" + currentThread + "] Main Thread Starts");

		 
		ScheduledExecutorService execService = Executors.newSingleThreadScheduledExecutor(new NamedThreadFactory());
		
		System.out.println("[" + currentThread + "] Current Thread:"+dateFormat.format(new Date()));
		
		ScheduledFuture<?> schedFuture1 = execService.schedule(new ScheduledTaskB(0), 4,  TimeUnit.SECONDS);
		ScheduledFuture<Integer> schedFuture2 = execService.schedule(new CallableTaskD(2, 3, 0), 6,  TimeUnit.SECONDS);
		execService.schedule(new ScheduledTaskB(0), 8,TimeUnit.SECONDS);
		ScheduledFuture<Integer> schedFuture4 = execService.schedule(new CallableTaskD(3,4,0), 10,  TimeUnit.SECONDS);
		
		execService.shutdown();
		
		System.out.println("[" + currentThread + "] Retrieving the results now:");
		
		System.out.println("[" + currentThread + "] Task-1 Result ="+schedFuture1.get());
		System.out.println("[" + currentThread + "] Task-2 Result ="+schedFuture2.get());
		System.out.println("[" + currentThread + "] Task-4 Result ="+schedFuture4.get());
		
		System.out.println("[" + currentThread + "] Main Thread Ends");

	}
}
