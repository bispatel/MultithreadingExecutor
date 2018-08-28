package com.thread.common;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class ScheduledTaskA extends TimerTask {

	private long sleepTime;
	private static int count = 0;
	private int instanceNum;
	private String taskId;

	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss.SSS");

	public ScheduledTaskA(long sleepTime) {
		this.sleepTime = sleepTime;
		this.instanceNum = ++count;
		this.taskId = "ScheduledTaskA-" + instanceNum;
	}

	@Override
	public void run() {
		Date startTime = new Date();
		Date scheduledForRunningTime = new Date(super.scheduledExecutionTime());
		String currentThread = Thread.currentThread().getName();
		System.out.println("#####[" + currentThread + "] <" + taskId + "> SCHEDULED TO RUN AT:"
				+ dateFormat.format(scheduledForRunningTime) + ", ACTUALLY STARTED AT:" + dateFormat.format(startTime)+" #####");


		try {
			TimeUnit.MILLISECONDS.sleep(sleepTime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("#####[" + currentThread + "] <" + taskId + "> FINISHED AT:"
				+ dateFormat.format(new Date())+" #####\n");

	}

}
