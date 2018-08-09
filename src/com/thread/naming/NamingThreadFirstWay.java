package com.thread.naming;

import com.thread.common.LoopTaskB;

public class NamingThreadFirstWay {

	public static void main(String[] args) {
		String currentThreadName =Thread.currentThread().getName();
		System.out.println("["+currentThreadName+ "] thread starts here..");
		new Thread(new LoopTaskB()).start();
		Thread t2 = new Thread(new LoopTaskB());
		t2.start();
		System.out.println("["+currentThreadName+ "] thread ended.");
	}
}
