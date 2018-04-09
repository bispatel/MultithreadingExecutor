package com.thread.common;

public class LoopTaskB implements Runnable {

	private static int count = 0;
	private int instanceNumber;
	private String taskId;

	@Override
	public void run() {
		Thread.currentThread().setName("My-Thread"+instanceNumber);
		String currentThread = Thread.currentThread().getName();
		System.out.println("#####[" + currentThread + "] <" + taskId+ "> STARTING...");
		for (int i = 1; i <= 10; i++) {
			System.out.println("["+currentThread + "] <" + taskId + ">TICK TACK:" + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("#####[" + currentThread + "] <" + taskId+ "> Ended...");
	}

	public LoopTaskB() {
		this.instanceNumber = ++count;
		this.taskId = "LoopTaskB"+instanceNumber;
	}

}
