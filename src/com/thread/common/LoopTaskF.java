package com.thread.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LoopTaskF implements Runnable {

	private static int count = 0;
	private int instanceNumber;
	private String taskId;

	@Override
	public void run() {
		String currentThread = Thread.currentThread().getName();
		System.out.println("#####[" + currentThread + "] <" + taskId + "> STARTING...");
		for (int i = 1;; i++) {
			System.out.println("[" + currentThread + "] <" + taskId + ">TICK TACK:" + i);
			doSomeWork();
			if(Thread.interrupted()) {
				System.out.println("*****[" + currentThread+ "]<" + taskId + "> Interrupted. Cancelling ...");
				break;
			}
		}
		System.out.println("*****[" + currentThread+ "]<" + taskId + "> Retrieving Interrupted status again.. "+Thread.interrupted());
		System.out.println("*****[" + currentThread + "]<" + taskId + "> Done ****");
	}

	private void doSomeWork() {

		for(int i=0;i<2;i++) {
			Collections.sort(generateDataSet());
		}
	}

	private List<Integer> generateDataSet(){
		List<Integer> intList = new ArrayList<>();
		for (int i=0;i<100000;i++) {
			intList.add(i);			
		}
		return intList;
	}
	public LoopTaskF() {
		this.instanceNumber = ++count;
		this.taskId = "LoopTaskF" + instanceNumber;
	}

}
