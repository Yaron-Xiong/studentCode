package com.accompnay.myTest;

import java.lang.instrument.Instrumentation;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class TestAgent {

	public static void premain(String args, Instrumentation inst) {
		inst.addTransformer(new MyTransformer(),true);
		try {
			inst.retransformClasses(ScheduledThreadPoolExecutor.class);
			System.out.println("增强完毕...");
		}catch (Exception e){
			e.printStackTrace();
			System.out.println("增强失败");
		}
	}
}
