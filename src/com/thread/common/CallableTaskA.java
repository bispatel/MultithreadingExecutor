package com.thread.common;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class CallableTaskA implements Callable<Integer> {

	private int a;
	private int b;
	private long sleepTime;
	private static int count = 0;
	private int instanceNum;
	private String taskId;

	public CallableTaskA(int a, int b, long sleepTime) {
		this.a = a;
		this.b = b;
		this.sleepTime = sleepTime;
		this.instanceNum = ++count;
		this.taskId = "CallableTaskA-" + instanceNum;
	}

	@Override
	public Integer call() throws Exception {
		String currentThread = Thread.currentThread().getName();
		System.out.println("#####[" + currentThread + "] <" + taskId + "> STARTING...");
		System.out.println("[" + currentThread + "] <" + taskId + "> Sleeping For..." + sleepTime + " milliseconds..");

		TimeUnit.MILLISECONDS.sleep(sleepTime);
		System.out.println("#####[" + currentThread + "] <" + taskId + "> Ended...");
		return a + b;
	}

}
