package com.yaronxiong.thread.myConcurrent;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Author:Accompany
 * Date:2019/12/18
 * 公平锁
 */
public class FairLock implements Runnable{
    private static ReentrantLock lock1 = new ReentrantLock(true);

    @Override
    public void run() {
        while (true){
            lock1.lock();
            try {
                System.out.println(Thread.currentThread().getName()+"  获取锁");
            }finally {
                lock1.unlock();
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new FairLock(),"t1");
        Thread t2 = new Thread(new FairLock(),"t2");
        t1.start();
        t2.start();
    }
}
