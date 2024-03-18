package com.yaronxiong.thread.myConcurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Author:Accompany
 * Date:2019/12/19
 * 信号量的测试
 */
public class SemaphoreDemo implements Runnable {
    final Semaphore semaphore = new Semaphore(5);
    @Override
    public void run() {
        try {
            semaphore.acquire();
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getId()+"  job done");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(20);
        final SemaphoreDemo demo = new SemaphoreDemo();
        for (int i = 0; i < 20; i++) {
            exec.submit(demo);
        }
    }
}
