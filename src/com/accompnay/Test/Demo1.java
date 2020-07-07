package com.accompnay.Test;

import com.accompnay.customizedThread.myConcurrent.ReenterLock;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Accompany
 */
public class Demo1 {

    public static ReentrantLock lock = new ReentrantLock();

    public static class Run implements Runnable {

        @Override
        public void run() {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "::获取锁成功");
                if (Thread.currentThread().getName().equals("t1")) {
                    System.out.println(Thread.currentThread().getName() + "::消费许可");
                    LockSupport.park();
                }
                TimeUnit.SECONDS.sleep(2);
                System.out.println(Thread.currentThread().getName() + "::done");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Run run = new Run();
        Thread t1 = new Thread(run, "t1");
        Thread t2 = new Thread(run, "t2");
        t1.start();
        t2.start();
        System.out.println(Thread.currentThread().getName() + "::给t1发布许可");
        //需要在start之前调用
        LockSupport.unpark(t1);
    }
}
