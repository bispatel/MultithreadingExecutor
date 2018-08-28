package com.thread.common;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class CallableTaskD implements Callable<Integer> {

	private int a;
	private int b;
	private long sleepTime;
	private static int count = 0;
	private int instanceNum;
	private String taskId;
	private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss.SSS");
	public CallableTaskD(int a, int b, long sleepTime) {
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
		System.out.println("#####[" + currentThread + "] <" + taskId + "> Finished at..."+dateFormat.format(new Date()) + "*******");
		return a + b;
	}

}
