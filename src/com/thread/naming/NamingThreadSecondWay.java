package com.thread.naming;

import com.thread.common.LoopTaskC;

public class NamingThreadSecondWay {

	public static void main(String[] args) {
		String currentThreadName =Thread.currentThread().getName();
		System.out.println("["+currentThreadName+ "] thread starts here..");
		new Thread(new LoopTaskC(),"My-Custome-Thread1").start();
		Thread t2 = new Thread(new LoopTaskC());
		//t2.setName("My-Custome-Thread2");
		t2.start();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t2.setName("My-Custome-Thread3");
		System.out.println("["+currentThreadName+ "] thread ended.");
	}
}
