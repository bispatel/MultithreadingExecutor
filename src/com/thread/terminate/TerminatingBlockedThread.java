package com.thread.terminate;

import java.util.concurrent.TimeUnit;

import com.thread.common.LoopTaskF;

public class TerminatingBlockedThread {

	public static void main(String[] args) throws InterruptedException {
		String currentThreadName = Thread.currentThread().getName();
		System.out.println("[" + currentThreadName + "] thread starts here..");

		LoopTaskF task1 = new LoopTaskF();
		LoopTaskF task2 = new LoopTaskF();
		LoopTaskF task3 = new LoopTaskF();

		Thread t1 = new Thread(task1, "My-Thread-1");
		Thread t2 = new Thread(task2, "My-Thread-2");
		Thread t3 = new Thread(task3, "My-Thread-3");
		t1.start();
		t2.start();
		t3.start();
		TimeUnit.MILLISECONDS.sleep(3000);
		
		System.out.println("[" + currentThreadName + "] Interrupting My-Thread-1 ...");
		t1.interrupt();
		System.out.println("[" + currentThreadName + "] Interrupting My-Thread-2 ...");
		t2.interrupt();
		System.out.println("[" + currentThreadName + "] Interrupting My-Thread-3 ...");
		t3.interrupt();

		System.out.println("[" + currentThreadName + "] thread ended.");

	}
}
