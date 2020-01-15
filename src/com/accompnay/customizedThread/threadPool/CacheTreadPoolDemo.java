package com.accompnay.customizedThread.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Author:Accompany
 * Date:2019/12/23
 * 不固定生成的线程数，最大值可到达Integer.MAX_VALUE
 * 适用于短周期任务
 */
public class CacheTreadPoolDemo {
    public static class MyTask implements Runnable{

        @Override
        public void run() {
            System.out.println(System.currentTimeMillis()+" ::"+Thread.currentThread().getId());
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++) {
            executor.submit(new MyTask());
        }
        executor.shutdown();
    }
}
