package com.accompnay.customizedThread.myConcurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Author:Accompany
 * Date:2019/12/18
 * 可重用锁的超时申请
 */
public class TimeLock implements Runnable {
    private static ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        try {
            if (lock.tryLock(5, TimeUnit.SECONDS)) {
                System.out.println("拿到锁");
                Thread.sleep(6000);
                System.out.println("睡眠结束");
            } else {
                System.out.println("没有拿到锁");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            if (lock.isHeldByCurrentThread()){
                lock.unlock();
                System.out.println("释放锁");
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new TimeLock());
        Thread t2 = new Thread(new TimeLock());
        t1.start();t2.start();
    }
}
