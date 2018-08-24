package com.thread.common;

public class LoopTaskG implements Runnable {

	private static int count = 0;
	private int instanceNumber;
	private String taskId;

	@Override
	public void run() {
		String currentThread = Thread.currentThread().getName();
		System.out.println("#####[" + currentThread + "] <" + taskId + "> STARTING...");
		for (int i = 1;; i++) {
			System.out.println("[" + currentThread + "] <" + taskId + ">TICK TACK:" + i);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				System.out.println("*****[" + Thread.currentThread().getName() + "]<" + taskId + "> Sleep Interrupted. Cancelling ****");
				break;
			}
			 
			
			
		}
		
	}

	 

	public LoopTaskG() {
		this.instanceNumber = ++count;
		this.taskId = "LoopTaskG" + instanceNumber;
	}

}
