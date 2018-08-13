package com.thread.common;

public class LoopTaskE implements Runnable {

	private static int count = 0;
	private int instanceNumber;
	private String taskId;
	private volatile boolean shutdown = false;

	@Override
	public void run() {
		String currentThread = Thread.currentThread().getName();
		System.out.println("#####[" + currentThread + "] <" + taskId + "> STARTING...");
		for (int i = 1;; i++) {
			System.out.println("[" + currentThread + "] <" + taskId + ">TICK TACK:" + i);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized (this) {
				if(shutdown) {
					break;
				}
			}
			
			
		}
		System.out.println("*****[" + Thread.currentThread().getName() + "]<" + taskId + "> Done ****");
	}

	public void cancel() {
		System.out.println("*****[" + Thread.currentThread().getName() + "]<" + taskId + "> Shutting Down ****");
		synchronized (this) {
			this.shutdown = true;
		}
	}

	public LoopTaskE() {
		this.instanceNumber = ++count;
		this.taskId = "LoopTaskE" + instanceNumber;
	}

}
