package com.accompnay.myConcurrent;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 不可重入锁使用
 */
public class ReenterLock implements Runnable {
    //重入锁
    static ReentrantLock lock = new ReentrantLock();
    public int i = 0;

    @Override
    public void run() {
        for (int j = 0; j < 1000000; j++) {
            lock.lock();
            i++;
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReenterLock reenterLock = new ReenterLock();
        Thread t1 = new Thread(reenterLock);
        Thread t2 = new Thread(reenterLock);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(reenterLock.i);
    }
}
