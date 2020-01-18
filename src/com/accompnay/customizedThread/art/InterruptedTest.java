package com.accompnay.customizedThread.art;

import java.util.concurrent.TimeUnit;

/**
 * @author Accompany
 * Date:2020/1/18
 * 什么是中断：
 *      中断是一种信号值，在Java中的体现为一个boolean值，使用Native修改的一个值
 *      中断并不是说一定要将线程停止，而是告知线程系统状态发送变化，可以做出一些操作来响应中断
 *      也可以不理会这个中断信号。
 *      中断信号可以作为线程之间的消息传递，例如存在两个线程对多个资源抢占，但是两个线程发生死锁现象
 *      可以通过一个线程向另外一个线程发送中断信号，让另外一个线程释放锁，以解决线程死锁的现象
 *
 * 特殊情况：
 * 线程是在sleep()然后接受到中断信号从sleep状态中变为运行态，中断信息会恢复为false（个人理解这样做的好处为）
 *
 * Thread static interrupted()：可以将线程的中断信号标志位改为false
 * instance Thread boolean isInterrupted()：线程实例返回当前线程是否被中断，并且将线程中断值改为false
 *
 * 自定义工作线程：需要自己去响应中断信号
 * Java方法响应中断信号，可以由Java自己去响应中断信号（例如sleep() 抛异常响应中断信号，并且将中断信号重置）
 *
 */
public class InterruptedTest {
    static class sleepRunnable implements Runnable{
        @Override
        public void run() {
            while (true){
                try {
                    TimeUnit.MILLISECONDS.sleep(200);
                } catch (InterruptedException e) {
                    break;
                }
            }
        }
    }
    static class workRunnable implements Runnable{
        @Override
        public void run() {
            while (true){

            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new sleepRunnable(),"sleepThread");
        Thread t2 = new Thread(new workRunnable(),"workThread");
        t1.start();
        t2.start();
        t1.interrupt();
        t2.interrupt();
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.println("是否被中断："+t1.isInterrupted());
        System.out.println("是否被中断："+t2.isInterrupted());
    }
}
