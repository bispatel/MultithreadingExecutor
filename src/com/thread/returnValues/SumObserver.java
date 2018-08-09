package com.thread.returnValues;

import com.thread.common.ResultListener;

public class SumObserver implements ResultListener<Integer> {

	private String taskId;

	public SumObserver(String taskId) {
		this.taskId = taskId;

	}

	@Override
	public void notifyResult(Integer result) {
		System.out.println("Result for task Id:" + taskId + " == " + result);
	}

}
