package com.thread.scheduling;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

import com.thread.common.ScheduledTaskA;
import com.thread.utils.TimerUtils;

public class SchedulingTaskForFixedDelayExecution {
	private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss.SSS");

	public static void main(String[] args) throws InterruptedException {
		String currentThread = Thread.currentThread().getName();
		System.out.println("[" + currentThread + "] Main Thread Starts");

		Timer timer = new Timer("Timer-Thread", true);// If true Daemon mode else user mode
		Date currTime = new Date();

		System.out.println("[" + currentThread + "] Current time:" + dateFormat.format(currTime));

		Date scheduledTime = TimerUtils.getFutureTime(currTime, 5000);
		long interval = 2000;
		timer.schedule(new ScheduledTaskA(1000), scheduledTime, interval);
		
		

		System.out.println("[" + currentThread + "] Task-1 first run scheduled for " + dateFormat.format(scheduledTime)
				+ " and then repeatedly at an interval of every " + interval / 1000 + " seconds!");
		
		long delayMilliSec = 4000;
		long interval2 = 2000;
		timer.schedule(new ScheduledTaskA(1000), delayMilliSec, interval2);
		
		System.out.println("[" + currentThread + "] Task-2 first run scheduled " + delayMilliSec/1000
		+ " seconds after "+dateFormat.format(currTime)+" and then repeatedly at an interval of every " + interval2 / 1000 + " seconds!");
		TimeUnit.MILLISECONDS.sleep(16000);
		System.out.println("[" + currentThread + "] Cancelling the Timer Now ...");
		timer.cancel();
		System.out.println("[" + currentThread + "] Main Thread Ends");

	}
}
