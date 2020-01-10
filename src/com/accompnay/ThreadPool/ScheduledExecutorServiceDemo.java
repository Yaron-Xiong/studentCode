package com.accompnay.ThreadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Author:Accompany
 * Date:2019/12/23
 *
 * @author Accompany
 * ScheduledExecutorService:任务调度器
 * ScheduledExecutorService.schedule():只会被调用一次，在时间间隔后进行调用
 * ScheduledExecutorService.scheduleAtFixedRate():重复执行任务，当任务结束后，如果任务执行时间超过了period那么将立即执行，如果没有超过，则等待
 * cheduledExecutorService.scheduleWithFixedDelay():重复执行任务，当任务结束后，间隔delay时间，再次执行任务
 *
 * 第二种和第三种重复任务，当其中某条发生异常，那么后续任务都会被打断
 * 所以持续任务需要注意好处理好异常，否则将无法持续执行
 */
public class ScheduledExecutorServiceDemo {
    public static void main(String[] args) {
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);
        System.out.println("开始时间"+System.currentTimeMillis() / 1000);
        ses.scheduleWithFixedDelay(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(System.currentTimeMillis() / 1000);
        }, 0,2, TimeUnit.SECONDS);
    }
}
