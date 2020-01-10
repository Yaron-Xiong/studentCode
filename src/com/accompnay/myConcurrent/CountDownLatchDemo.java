package com.accompnay.myConcurrent;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Author:Accompany
 * Date:2019/12/20
 * 倒计数器
 */
public class CountDownLatchDemo implements Runnable {
    static final CountDownLatch countDownLatch = new CountDownLatch(10);
    static final CountDownLatchDemo demo = new CountDownLatchDemo();
    @Override
    public void run() {
        try {
            //检查模拟任务
            Thread.sleep(new Random().nextInt(10)*1000);
            System.out.println(Thread.currentThread().getName()+" done");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            //计数器减一
            countDownLatch.countDown();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newFixedThreadPool(20);
        for (int i = 0; i < 20; i++) {
            exec.submit(demo);
        }
        //等待计数器
        countDownLatch.await();
        System.out.println("all start");
        //释放线程池
        exec.shutdown();
    }
}
