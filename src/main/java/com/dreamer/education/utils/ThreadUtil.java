package com.dreamer.education.utils;

public class ThreadUtil {
	public static void sleep(Long timespan){
		try {
			Thread.sleep(timespan);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
