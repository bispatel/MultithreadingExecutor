package com.thread.common;

import java.util.concurrent.CountDownLatch;

public class LoopTaskI implements Runnable {

	private static int count = 0;
	private int instanceNumber;
	private String taskId;

	private CountDownLatch latch;
	@Override
	public void run() {
		boolean isRunningInDaemonThread = Thread.currentThread().isDaemon();
		String threadType = isRunningInDaemonThread ? "Daemon" : "User";
		String currentThread = Thread.currentThread().getName();
		System.out.println("#####[" + currentThread + "," + threadType + "] <" + taskId + "> STARTING...");
		for (int i = 1; i <= 3; i++) {
			System.out.println("[" + currentThread + "," + threadType + "] <" + taskId + ">TICK TACK:" + i);
			try {
				Thread.sleep((long)Math.random()*1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("#####[" + currentThread + "," + threadType + "] <" + taskId + "> Ended...");
		if(latch!=null) {
			latch.countDown();
			
			System.out.println("#####[" + currentThread + "," + threadType + "] <" + taskId + "> LATCH COUNT ="+latch.getCount());
		}
	}

	public LoopTaskI(CountDownLatch latch) {
		this.latch=latch;
		this.instanceNumber = ++count;
		this.taskId = "LoopTaskI" + instanceNumber;
	}

}
