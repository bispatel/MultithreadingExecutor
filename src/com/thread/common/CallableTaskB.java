package com.thread.common;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class CallableTaskB implements Callable<TaskResult<String, Integer>> {

	private int a;
	private int b;
	private long sleepTime;
	private static int count = 0;
	private int instanceNum;
	private String taskId;

	public CallableTaskB(int a, int b, long sleepTime) {
		this.a = a;
		this.b = b;
		this.sleepTime = sleepTime;
		this.instanceNum = ++count;
		this.taskId = "CallableTaskB-" + instanceNum;
	}

	@Override
	public TaskResult<String, Integer> call() throws Exception {
		String currentThread = Thread.currentThread().getName();
		System.out.println("#####[" + currentThread + "] <" + taskId + "> STARTING...");
		System.out.println("[" + currentThread + "] <" + taskId + "> Sleeping For..." + sleepTime + " milliseconds..");

		TimeUnit.MILLISECONDS.sleep(sleepTime);
		System.out.println("#####[" + currentThread + "] <" + taskId + "> Ended...");
		return new TaskResult<String, Integer>(taskId, a+b);
	}

}
