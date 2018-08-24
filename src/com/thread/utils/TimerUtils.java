package com.thread.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TimerUtils {

	private TimerUtils() {

	}

	public static Date getFutureTime(Date initTime, long milliSecond) {
		Calendar cal = GregorianCalendar.getInstance();
		cal.setTimeInMillis(initTime.getTime() + milliSecond);
		return cal.getTime();
	}

}
