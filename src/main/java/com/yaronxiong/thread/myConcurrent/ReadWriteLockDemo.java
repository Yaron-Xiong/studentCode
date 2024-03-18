package com.yaronxiong.thread.myConcurrent;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Author:Accompany
 * Date:2019/12/19
 * 读写锁
 */
public class ReadWriteLockDemo {
    private static Lock lock = new ReentrantLock();
    private static ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
    private static Lock readLock = reentrantReadWriteLock.readLock();
    private static Lock writeLock = reentrantReadWriteLock.writeLock();
    private int value ;
    public int readValue(Lock lock) throws InterruptedException {
        try {
            lock.lock();
            System.out.println("正在进行读操作");
            Thread.sleep(5000);
            return value;
        }finally {
            lock.unlock();
        }
    }
    public void writeValue(Lock lock,int value) throws InterruptedException {
        try {
            lock.lock();
            System.out.println("正在进行写操作");
            Thread.sleep(5000);
            this.value = value;
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        //共同去操作这个对象
        ReadWriteLockDemo demo = new ReadWriteLockDemo();
        Runnable readRunnable = ()->{
            try {
                int i = demo.readValue(readLock);
                System.out.println("value值："+i);
                //demo.readValue(lock);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Runnable writeRunnable = ()->{
            try {
                demo.writeValue(writeLock,new Random().nextInt());
                //demo.writeValue(lock,new Random().nextInt());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        for (int i = 18; i < 20; i++) {
            Thread writeThread = new Thread(writeRunnable);
            writeThread.start();
        }
        for (int i = 0; i < 18; i++) {
            Thread readThread = new Thread(readRunnable);
            readThread.start();
        }

    }
}
