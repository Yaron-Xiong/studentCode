package com.accompnay.customizedThread.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Author:Accompany
 * Date:2019/12/23
 * 固定大小的线程池，最多只能使用n个线程，多余任务，等待空闲线程
 */
public class TreadPoolDemo {
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
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            executor.submit(new MyTask());
        }
        executor.shutdown();
    }
}
