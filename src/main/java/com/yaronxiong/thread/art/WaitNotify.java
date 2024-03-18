package com.yaronxiong.thread.art;

import java.util.concurrent.TimeUnit;

/**
 * @author Accompany
 * Date:2020/1/18
 * 等待通知机制：
 * 通过等待通知机制完成多线程之间的信息交互，例如完成顺序访问
 * 如果不存在等待通知机制的话，通过中断更新标志位来实现等待通知机制会存在什么问题？
 * while(flag){
 * //作用位比避免大量占用cpu
 * Thread.sleep(xxx);
 * }
 * doSomeing!
 * 看上述代码会发现会存在循环，并且存在sleep()的睡眠时间
 * 缺点：
 * 1.不能够及时响应flag的变化，因为存在sleep()方法
 * 2.存在CPU无用开销 因为不断的访问flag是否发生变化
 * <p>
 * 故Java存在等待通知机制 wait/notify
 * 那么等待通知机制和中断信号机制有什么区别呢？
 * 等待通知机制：可以与其余线程在执行部分代码的时候协作执行 例如当需要借助别人线程去计算结果
 * 需要使用其他线程运算结果的时候
 * <p>
 * 中断信号机制：当系统出现意料之外的异常，例如超时等待，或者陷入死锁，可以通过使用中断信号使其退出
 * 一个线程长期占用一个资源不放，导致系统死锁，可以让线程响应中断信号，并且释放资源
 * <p>
 * 等待通知机制提供了大致为下面三种方法完成等待通知
 * wait()：将当前线程放入当前锁对象监视器的等待队列（会释放持有资源）
 * notify()：随机唤醒当前锁对象的等待队列中的一个线程（被唤醒的线程，需要等待资源释放后才能执行）
 * notiry()：唤醒全部线程进行资源抢占
 * <p>
 * 问题1： notify()和notifyAll()的区别是什么?
 * notifyAll并不是将所有线程唤醒，这就涉及到了等待通知机制的底层实现了
 * 在底层实现中，会存在两个池
 * 同步队列（锁池）：锁池存放的是获取锁失败的线程池，锁池中的线程会进入对锁的争夺
 * 等待队列（等待池）：线程调用了wait方法之后线程就会进入等待池
 * 所以nofity/notifyAll的区别也就是
 * nitify会将等待池随机一个线程放入锁池
 * notifyAll会将等待池全部线程放入锁池
 * <p>
 * <p>
 * <p>
 * 等待通知机制的经典范式
 * 消费者（也就是需要依赖别的线程的结果）
 * synchronized(obj){
 *   //循环标志为：重复检测标志值是否到达预期效果（同时做到了避免一个生产者多个消费者flag的不确定性）
 *  while(flag){
 *      obj.wait();
 *  }
 *  doSomeing
 * }
 * <p>
 * 生产者（被依赖方）
 * synchronized(obj){
 *     //修改标志位
 *     flag = xxx;
 *     // 重要**** 将等待队列的对象移动到同步队列
 *     obj.notifyAll();
 * }
 */
public class WaitNotify {
    static volatile boolean flag = true;
    static final Object object = new Object();

    public static void main(String[] args) throws InterruptedException {
        Wait wait = new Wait();
        Thread t1 = new Thread(wait, "wait1Thread");
        Thread t2 = new Thread(wait, "wait2Thread");
        Thread t3 = new Thread(new Notify(), "notifyThread");
        t1.start();
        t2.start();
        TimeUnit.SECONDS.sleep(2);
        t3.start();
    }

    static class Wait implements Runnable {
        @Override
        public void run() {
            synchronized (object) {
                //当条件不满足时，继续循环，同时释放锁
                while (flag) {
                    System.out.println(Thread.currentThread().getName() + "flag is true.will wait other thread run");
                    try {
                        //当接受到了notify的信号并不会将线程从Waiting状态->Runnable状态
                        //而是会从Waiting->Blocking->拿到对象监视器资源->Runnable
                        object.wait();
                    } catch (InterruptedException e) {
                        //可以响应中断信号
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + "work done");
            }
        }
    }

    static class Notify implements Runnable {
        @Override
        public void run() {
            synchronized (object) {
                flag = false;
                object.notifyAll();
                System.out.println("将线程从等待池放入锁池中");
            }
        }
    }
}
