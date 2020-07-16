package com.accompnay.customizedThread.myConcurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Author:Accompany
 * Date:2019/12/19
 * 需要在有锁的情况下
 * Condition的使用->类似于 Object.wait()、Object.notify()
 */
public class ReenterLockCondition implements Runnable {
    private static ReentrantLock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();

    @Override
    public void run() {
        try {
            lock.lock();
            condition.await(); //丢失锁
            System.out.println("job done");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new ReenterLockCondition());
        t1.start();
        Thread.sleep(2000);
        lock.lock();
        condition.signal();//唤醒等待线程、线程在唤醒后需要等待锁资源的释放
        lock.unlock(); //不放弃锁的话，那么线程将一直等待
    }
}
