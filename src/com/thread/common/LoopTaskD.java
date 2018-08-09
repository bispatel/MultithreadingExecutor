package com.thread.common;

public class LoopTaskD implements Runnable {

	private static int count = 0;
	private int instanceNumber;
	private String taskId;
	private long sleepTime;

	@Override
	public void run() {
		boolean isRunningInDaemonThread = Thread.currentThread().isDaemon();
		String threadType = isRunningInDaemonThread ? "Daemon" : "User";
		String currentThread = Thread.currentThread().getName();
		System.out.println("#####[" + currentThread + "," + threadType + "] <" + taskId + "> STARTING...");
		for (int i = 1; i <= 10; i++) {
			System.out.println("[" + currentThread + "," + threadType + "] <" + taskId + ">TICK TACK:" + i);
			try {
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("#####[" + currentThread + "," + threadType + "] <" + taskId + "> Ended...");
	}

	public LoopTaskD(long sleepTime) {
		this.sleepTime =sleepTime;
		this.instanceNumber = ++count;
		this.taskId = "LoopTaskD" + instanceNumber;
	}

}
