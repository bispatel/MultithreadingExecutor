package com.thread.common;

import java.util.concurrent.TimeUnit;

public class ValueReturningTaskB implements Runnable {

	private int a;
	private int b;
	private long sleepTime;
	private static int count = 0;
	private int instanceNum;
	private String taskId;
	private ResultListener<Integer> listener;
	private int sum = 0;

	public ValueReturningTaskB(int a, int b, long sleepTime, ResultListener<Integer> listener) {
		this.a = a;
		this.b = b;
		this.sleepTime = sleepTime;
		this.instanceNum = ++count;
		this.taskId = "ValueReturningTaskB-" + instanceNum;
		this.listener = listener;
	}

	@Override
	public void run() {
		String currentThread = Thread.currentThread().getName();
		System.out.println("#####[" + currentThread + "] <" + taskId + "> STARTING...");
		System.out.println("[" + currentThread + "] <" + taskId + "> Sleeping For..." + sleepTime + " milliseconds..");

		try {
			TimeUnit.MILLISECONDS.sleep(sleepTime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sum = a + b;
		System.out.println("#####[" + currentThread + "] <" + taskId + "> Ended...");
		listener.notifyResult(sum);
	}

}
