package com.accompnay.myConcurrent;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 不可重入锁使用
 */
public class ReenterLock implements Runnable {
    private ReentrantLock lock = new ReentrantLock();
    private int i = 0;

    @Override
    public void run() {
        try {
            lock.lock();
            for (int i1 = 0; i1 < 100; i1++) {
                i++;
            }
            System.out.println("正在执行");
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReenterLock reenterLock = new ReenterLock();
        Thread t1 = new Thread(reenterLock);
        Thread t2 = new Thread(reenterLock);
        t1.start();t2.start();
        t1.join();t2.join();
        System.out.println(reenterLock.i);
    }
}
