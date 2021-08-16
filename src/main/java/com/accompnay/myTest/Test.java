package com.accompnay.myTest;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;

public class Test {

	public static void main(String[] args) {
		ScheduledThreadPoolExecutor scheduledThreadPoolExecutor
				= new ScheduledThreadPoolExecutor(1, new ThreadPoolExecutor.DiscardPolicy());
		scheduledThreadPoolExecutor.execute(()->{
			System.out.println("执行定时任务~");
		});
	}

}
