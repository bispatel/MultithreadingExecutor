package com.thread.common;

public class LoopTaskA implements Runnable {

	private static int count = 0;
	private int id;

	@Override
	public void run() {
		System.out.println("##### <Task-" + id+ "> STARTING...");
		for (int i = 1; i <= 10; i++) {
			System.out.println("Task <" + id + ">TICK TACK:" + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("##### <Task-" + id+ "> Done...");
	}

	public LoopTaskA() {
		this.id = ++count;
	}

}
