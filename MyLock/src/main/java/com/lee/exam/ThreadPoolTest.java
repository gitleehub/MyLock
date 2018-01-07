package com.lee.exam;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ScheduledExecutorService excutor = Executors.newScheduledThreadPool(5);
		ScheduledFuture<Integer> result = null;
		 result = excutor.schedule(()->{
			System.out.println(Thread.currentThread().getName());
			return 123;
		}, 2, TimeUnit.SECONDS);
		 System.out.println(result.get());
	}
	
}
