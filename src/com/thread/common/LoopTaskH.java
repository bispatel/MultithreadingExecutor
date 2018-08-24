package com.thread.common;

public class LoopTaskH implements Runnable {

	private static int count = 0;
	private int instanceNumber;
	private String taskId;

	private boolean sleepInterrupted = false;

	@Override
	public void run() {
		String currentThread = Thread.currentThread().getName();
		System.out.println("#####[" + currentThread + "] <" + taskId + "> STARTING...");
		for (int i = 1;; i++) {
			System.out.println("[" + currentThread + "] <" + taskId + ">TICK TACK:" + i);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				System.out.println("*****[" + Thread.currentThread().getName() + "]<" + taskId
						+ "> Sleep Interrupted. Setting the Flag ....");
				sleepInterrupted = true;
			}

			doSomeMoreWorks();
			if (sleepInterrupted || Thread.interrupted()) {
				System.out.println("*****[" + Thread.currentThread().getName() + "]<" + taskId + "> Interrupped. So Cancelling....");
				break;
			}
		}

	}

	private void doSomeMoreWorks() {
		System.out.println("*****[" + Thread.currentThread().getName() + "]<" + taskId + "> Doing Some Work ....");
	}

	public LoopTaskH() {
		this.instanceNumber = ++count;
		this.taskId = "LoopTaskH" + instanceNumber;
	}

}
