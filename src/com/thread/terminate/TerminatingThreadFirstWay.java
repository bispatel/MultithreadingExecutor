package com.thread.terminate;

import java.util.concurrent.TimeUnit;

import com.thread.common.LoopTaskE;

public class TerminatingThreadFirstWay {

	public static void main(String[] args) throws InterruptedException {
		String currentThreadName = Thread.currentThread().getName();
		System.out.println("[" + currentThreadName + "] thread starts here..");

		LoopTaskE t1 = new LoopTaskE();
		LoopTaskE t2 = new LoopTaskE();
		LoopTaskE t3 = new LoopTaskE();

		new Thread(t1, "My-Thread-1").start();
		new Thread(t2, "My-Thread-2").start();
		new Thread(t3, "My-Thread-3").start();
		TimeUnit.MILLISECONDS.sleep(5000);
		t1.cancel();
		t2.cancel();
		t3.cancel();

		System.out.println("[" + currentThreadName + "] thread ended.");

	}
}
