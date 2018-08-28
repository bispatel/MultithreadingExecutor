package com.thread.scheduling.executors;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import com.thread.common.NamedThreadFactory;
import com.thread.common.ScheduledTaskB;
import com.thread.utils.TimerUtils;

public class SchedulingTaskForFixedDelayRepeatedExecUsingExecutor {
	private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss.SSS");

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		String currentThread = Thread.currentThread().getName();
		System.out.println("[" + currentThread + "] Main Thread Starts");

		//ScheduledExecutorService execService = Executors.newSingleThreadScheduledExecutor(new NamedThreadFactory());
		ScheduledExecutorService execService = Executors.newScheduledThreadPool(3,new NamedThreadFactory());

		System.out.println("[" + currentThread + "] Current Thread:" + dateFormat.format(new Date()));

		ScheduledFuture<?> schedFuture1 = execService.scheduleWithFixedDelay(new ScheduledTaskB(1000), 4, 2,
				TimeUnit.SECONDS);
		ScheduledFuture<?> schedFuture2 = execService.scheduleWithFixedDelay(new ScheduledTaskB(3000), 4, 2,
				TimeUnit.SECONDS);

		for (int i = 10; i < 10; i++) {

			System.out.print("[" + currentThread + "] Next run of Task -1 scheduled at approx..");
			Date scheduledTime = TimerUtils.getFutureTime(new Date(), schedFuture1.getDelay(TimeUnit.MILLISECONDS));
			System.out.println(dateFormat.format(scheduledTime));
			TimeUnit.MILLISECONDS.sleep(3000);
		}
		TimeUnit.MILLISECONDS.sleep(15000);
		execService.shutdown();

		System.out.println("[" + currentThread + "] Main Thread Ends");

	}
}
