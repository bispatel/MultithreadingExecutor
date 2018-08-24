package com.thread.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

public class CallableTaskC implements Callable<Long> {

	private static int count = 0;
	private int instanceNumber;
	private String taskId;
	private boolean isThreadInterrupted = false;

	@Override
	public Long call() throws Exception {
		String currentThread = Thread.currentThread().getName();
		System.out.println("#####[" + currentThread + "] <" + taskId + "> STARTING...");

		long totalTimetakenInMillis = 0;
		for (int i = 0; i < 1000; i++) {
			System.out.println("[" + currentThread + "] <" + taskId + ">Current Running Average="
					+ (i == 0 ? 0 : totalTimetakenInMillis / (2 * i)));

			long timeTakenInMills = doSomeWork();
			totalTimetakenInMillis += timeTakenInMills;

			if (Thread.interrupted()) {
				System.out.println("*****[" + currentThread + "]<" + taskId + "> Interrupted. Cancelling ...");
				isThreadInterrupted = true;
				break;
			}
		}
		System.out.println("*****[" + currentThread + "]<" + taskId + "> Retrieving Interrupted status again.. "
				+ Thread.interrupted());
		System.out.println("*****[" + currentThread + "]<" + taskId + "> Done ****");
		return isThreadInterrupted ? -1 : totalTimetakenInMillis / (2 * 1000);
	}

	private long doSomeWork() {
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < 2; i++) {
			Collections.sort(generateDataSet());
		}
		return System.currentTimeMillis() - startTime;
	}

	private List<Integer> generateDataSet() {
		List<Integer> intList = new ArrayList<>();
		for (int i = 0; i < 100000; i++) {
			intList.add(i);
		}
		return intList;
	}

	public CallableTaskC() {
		this.instanceNumber = ++count;
		this.taskId = "CallableTaskC" + instanceNumber;
	}

}
