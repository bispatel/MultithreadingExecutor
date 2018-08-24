package com.thread.terminate;

import java.util.concurrent.TimeUnit;

import com.thread.common.LoopTaskG;
import com.thread.common.LoopTaskH;

public class TerminatingBlockedThread {

	public static void main(String[] args) throws InterruptedException {
		String currentThreadName = Thread.currentThread().getName();
		System.out.println("[" + currentThreadName + "] Main thread starts here..");

		LoopTaskG task1 = new LoopTaskG();
		LoopTaskG task2 = new LoopTaskG();
		LoopTaskG task3 = new LoopTaskG();
		
		LoopTaskH task4 = new LoopTaskH();
		LoopTaskH task5 = new LoopTaskH();
		LoopTaskH task6 = new LoopTaskH();

		Thread t1 = new Thread(task1, "My-Thread-1");
		Thread t2 = new Thread(task2, "My-Thread-2");
		Thread t3 = new Thread(task3, "My-Thread-3");
		t1.start();
		t2.start();
		t3.start();
		Thread t4 = new Thread(task4, "My-Thread-4");
		Thread t5 = new Thread(task5, "My-Thread-5");
		Thread t6 = new Thread(task6, "My-Thread-6");
		t4.start();
		t5.start();
		t6.start();
		
		TimeUnit.MILLISECONDS.sleep(3000);
		
		System.out.println("[" + currentThreadName + "] Interrupting My-Thread-1 ...");
		t1.interrupt();
		
		System.out.println("[" + currentThreadName + "] Interrupting My-Thread-2 ...");
		t2.interrupt();
		
		System.out.println("[" + currentThreadName + "] Interrupting My-Thread-3 ...");
		t3.interrupt();
		
		System.out.println("[" + currentThreadName + "] Interrupting My-Thread-4 ...");
		t4.interrupt();
		
		System.out.println("[" + currentThreadName + "] Interrupting My-Thread-5 ...");
		t5.interrupt();
		
		System.out.println("[" + currentThreadName + "] Interrupting My-Thread-6 ...");
		t6.interrupt();

		System.out.println("[" + currentThreadName + "] Main thread ended.");

	}
}
