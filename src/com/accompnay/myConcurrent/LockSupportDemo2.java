package com.accompnay.myConcurrent;

import java.util.concurrent.locks.LockSupport;

/**
 * Author:Accompany
 * Date:2019/12/23
 * LockSupport支持中断
 * 机制不是抛出InterruptedException
 * 如果发生中断请求/取消中断，则继续执行
 */
public class LockSupportDemo2 {
    public final static Object object = new Object();
    public static ChangeObjectThread t1 = new ChangeObjectThread("t1");
    public static ChangeObjectThread t2 = new ChangeObjectThread("t2");

    public static class ChangeObjectThread extends Thread{
        public ChangeObjectThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            synchronized (object){
                System.out.println("in"+Thread.currentThread().getName());
                LockSupport.park(); //挂起线程 不会放弃锁 导致其他线程陷入等待 当发生中断 会退出挂起
                System.out.println(Thread.currentThread().getName()+"挂起结束");
                if (Thread.interrupted()){
                    System.out.println("线程被中断");
                }
                System.out.println(Thread.currentThread().getName()+"线程执行完毕");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        t1.start();
        t1.interrupt();
        t2.start();
        LockSupport.unpark(t2);
        //LockSupport.unpark(t1);
        t1.join();
        t2.join();
    }
}
