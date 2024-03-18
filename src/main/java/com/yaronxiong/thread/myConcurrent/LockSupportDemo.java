package com.yaronxiong.thread.myConcurrent;

import java.util.concurrent.locks.LockSupport;

/**
 * Author:Accompany
 * Date:2019/12/23
 * LockSupport.park() 会挂起一个线程
 * LockSupport.unpark() 唤醒一个线程
 *
 * Java无法保证 unpark会在park之后执行
 * park机制：内部维持一个许可，park使许可不可用，unpark使许可可用
 * 所有最后不会出现使用 Thread.suspend和Thread.resume 机制导致线程无法挂起或唤醒
 */
public class LockSupportDemo {
    public static Object object = new Object();
    public static ChangeObjectThread t1 = new ChangeObjectThread("t1");
    public static ChangeObjectThread t2 = new ChangeObjectThread("t2");

    public static class ChangeObjectThread extends Thread{
        public ChangeObjectThread(String name){
            super(name);
        }
        @Override
        public void run() {
            synchronized (object){
                System.out.println("in "+ Thread.currentThread().getName());
                LockSupport.park();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        t1.start();
        Thread.sleep(100);
        t2.start();
        LockSupport.unpark(t1);
        LockSupport.unpark(t2);
        t1.join();
        t2.join();
    }
}
