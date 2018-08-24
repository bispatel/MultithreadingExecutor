package com.thread.common;

import java.util.concurrent.Callable;

public class FactorialTaskA implements Callable<Long> {

	private static int count = 0;
	private int instanceNumber;
	private String taskId;
	private volatile boolean shutdown = false;
	private long a;
	private long sleepTime;
	private long factorial;

	@Override
	public Long call() throws Exception {
		String currentThread = Thread.currentThread().getName();
		System.out.println("#####[" + currentThread + "] <" + taskId + "> STARTING...");
		
		factorial =1L;
		for (long i = 1;i<=a; i++) {
			factorial *=i;
			System.out.println("[" + currentThread + "] <" + taskId + ">Iteration-" + i+". Intermediate Result = "+factorial);
			try {
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (this) {
				if (shutdown) {
					factorial = -1L;
					break;
				}
			}
		}
		System.out.println("*****[" + Thread.currentThread().getName() + "]<" + taskId + "> Done ****");
		return factorial;
	}

	public void cancel() {
		System.out.println("*****[" + Thread.currentThread().getName() + "]<" + taskId + "> Shutting Down ****");
		synchronized (this) {
			this.shutdown = true;
		}
	}

	public FactorialTaskA(long a, long sleepTime) {
		this.a = a;
		this.sleepTime = sleepTime;
		this.instanceNumber = ++count;
		this.taskId = "FactorialTaskA" + instanceNumber;
	}

}
