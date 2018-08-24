package com.thread.common;

import java.util.concurrent.TimeUnit;

public class ValueReturningTaskC implements Runnable {
	
	private int a;
	private int b;
	private long sleepTime;
	private int sum;
	private static int count=0;
	private int instanceNum;
	private String taskId;
	
	public ValueReturningTaskC (int a, int b, long sleepTime){
		this.a=a;
		this.b=b;
		this.sleepTime=sleepTime;
		this.instanceNum = ++count;
		this.taskId = "ValueReturningTaskC-"+ instanceNum;
	}

	@Override
	public void run() {
		String currentThread = Thread.currentThread().getName();
		System.out.println("#####[" + currentThread + "] <" + taskId+ "> STARTING...");
		System.out.println("[" + currentThread + "] <" + taskId+ "> Sleeping For..."+sleepTime+ " milliseconds..");
		 
			try {
				TimeUnit.MILLISECONDS.sleep(sleepTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			sum = a+b;			
		System.out.println("#####[" + currentThread + "] <" + taskId+ "> Ended...");
		
		
	}
	
	public int getSum(){
		
		return sum;
	}

}
