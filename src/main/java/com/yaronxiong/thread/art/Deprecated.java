package com.yaronxiong.thread.art;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author Accompany
 * Date:2020/1/18
 * Java线程在以前提供了三个方法，现在已经不推荐使用，因为这三种方法存在不安全性
 * Thread void suspend(); 挂起一个线程，但是不会释放线程占用的资源，相当于占有资源睡眠
 * Thread void resume(); 唤起一个线程，不保证会在suspend()之后调用，导致线程无法正常被唤起
 * Thread void stop(); 强制终止一个线程，不保证该线程持有的资源被释放，可能会导致系统资源占用异常  类似于抢占式 由系统直接停止线程
 * <p>
 * <p>
 * <p>
 * 需要注意：
 * suspend()：会出现一种很诡异的现象，当调用该方法挂起一个线程，使用jstack 查看线程的时候，会
 * 发现被挂起的线程不是一种wait()的状态，而是Runnable的状态，如果使用该方法的话会导致
 * 在排查问题的时候忽略，这也可能是这个方法被废弃的原因之一
 *
 * resume():
 * 正在情况下 resume()会在suspend()之前执行，但是在多线程环境下，不一定保证这个执行循序
 * 导致了 resume()会在suspend()之前执行，会出现唤起失败，导致线程运行结果与预期不一致
 */
public class Deprecated {
    public static void main(String[] args) throws InterruptedException {
        DateFormat format = new SimpleDateFormat("HH:mm:ss");
        Thread t1 = new Thread(new DateRunnable(), "DateFormatThread");
        t1.setDaemon(true);
        t1.start();
        //避免守护线程G了，先让线程执行3秒钟
        TimeUnit.SECONDS.sleep(3);
        t1.suspend();  //挂起线程
        System.out.println("main线程挂起t1线程" + format.format(new Date()));
        TimeUnit.SECONDS.sleep(3);
        t1.resume();  //唤起线程
        System.out.println("main线程唤醒t1线程" + format.format(new Date()));
        TimeUnit.SECONDS.sleep(3);
        t1.stop();
        System.out.println("main线程停止t1线程" + format.format(new Date()));
        TimeUnit.SECONDS.sleep(3);
    }

    static class DateRunnable implements Runnable {
        @Override
        public void run() {
            DateFormat format = new SimpleDateFormat("HH:mm:ss");
            while (true) {
                //每秒钟打印一次
                System.out.println("线程正在执行" + format.format(new Date()));
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
