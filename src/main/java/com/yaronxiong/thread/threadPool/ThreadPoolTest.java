package com.yaronxiong.thread.threadPool;

import java.util.concurrent.TimeUnit;

/**
 * @author Accompany
 * Date:2020/1/21
 */
public class ThreadPoolTest {
    public static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        DefaultThreadPool<Runnable> threadPool = new DefaultThreadPool<>();
        for (int i = 0; i < 10; i++) {
            threadPool.execute(new Job());
        }
        TimeUnit.SECONDS.sleep(3);
        System.out.println(count);
        System.out.println(threadPool.getJobSize());
    }

    static class Job implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                count++;
            }
        }
    }
}
