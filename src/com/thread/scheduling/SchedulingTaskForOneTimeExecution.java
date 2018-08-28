package com.thread.scheduling;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

import com.thread.common.ScheduledTaskA;
import com.thread.utils.TimerUtils;

public class SchedulingTaskForOneTimeExecution {
	private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss.SSS");

	public static void main(String[] args) throws InterruptedException {
		String currentThread = Thread.currentThread().getName();
		System.out.println("[" + currentThread + "] Main Thread Starts");

		Timer timer = new Timer("Timer-Thread", true);//If true Daemon mode else user mode
		Date currTime = new Date();
		Date scheduledTime = TimerUtils.getFutureTime(currTime, 5000);
		
		System.out.println("[" + currentThread + "] Current Time:" + dateFormat.format(scheduledTime));
		timer.schedule(new ScheduledTaskA(0), scheduledTime);
		System.out.println("[" + currentThread + "] Task -1 scheduled for running at a specific time:"
				+ dateFormat.format(scheduledTime));

		//**********************************************************************/
		long delayMillisec = 10000;
		ScheduledTaskA task2 = new ScheduledTaskA(0);
		timer.schedule(task2, delayMillisec);
		
		System.out.println("[" + currentThread + "] Task-2 scheduled for running at:"+delayMillisec/1000 +" seconds INITIAL-DELAY after current-time i.e. at "
				+ dateFormat.format(new Date(task2.scheduledExecutionTime())));
		
		//**********************************************************************/
		
		long delayMillisec2 = 12000;
		ScheduledTaskA task3 = new ScheduledTaskA(0);
		timer.schedule(task3, delayMillisec2);
		
		System.out.println("[" + currentThread + "] Task-3 scheduled for running at:"+delayMillisec2/1000 +" seconds INITIAL-DELAY after current-time i.e. at "
				+ dateFormat.format(new Date(task3.scheduledExecutionTime())));
		
		//**********************************************************************/
        Date scheduledTime2 = TimerUtils.getFutureTime(currTime, 30000);
        ScheduledTaskA task4 = new ScheduledTaskA(0);
		
		timer.schedule(task4, scheduledTime2);
		System.out.println("[" + currentThread + "] Task -4 scheduled to run at a specific time:"
				+ dateFormat.format(new Date(task4.scheduledExecutionTime())));

		//**********************************************************************/
		TimeUnit.MILLISECONDS.sleep(32000);
		System.out.println("Cancelling the Timer");
		timer.cancel();
		

		
		System.out.println("[" + currentThread + "] Main Thread Ends");

	}
}
