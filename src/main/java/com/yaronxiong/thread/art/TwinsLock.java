package com.yaronxiong.thread.art;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @author Accompany
 * Date:2020/1/21
 * 允许两个线程同时执行
 * 原理：
 * 把Sates设置为2
 * states = 2 ：表示还没有线程占用
 * states = 1 ；表示有一个线程
 * states = 0 :表示获取失败
 *
 * tryAcquireShared：返回结果的作用是告诉AQS资源变化情况，如果>0表示可以占用 <0的时候会阻塞
 * tryReleaseShared: 返回结果为资源
 */
public class TwinsLock {
    static class Syn extends AbstractQueuedSynchronizer{
        public Syn(){
            setState(2);
        }
        @Override
        protected int tryAcquireShared(int arg) {
            for (;;){
                int current = getState();
                int newCount = current - arg;
                //如果newCount<0表示获取状态失败 否则将states设置为newCount
                if (newCount<0||compareAndSetState(current,newCount)){
                    return newCount;
                }
            }
        }

        @Override
        protected boolean tryReleaseShared(int arg) {
            for (;;){
                int current = getState();
                int newCount = current+arg;
                if (compareAndSetState(current,newCount)){
                    return true;
                }
            }
        }

    }
    private static final Syn lock = new Syn();

    public static void main(String[] args) throws InterruptedException {
        Work work = new Work();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(work, "Thread-name-" + i);
            thread.start();
        }
        for (int i = 0; i < 10; i++) {
            TimeUnit.SECONDS.sleep(1);
            System.out.println();
        }
    }

    static class Work implements Runnable{

        @Override
        public void run() {
            while (true){
                lock.acquireShared(1);
                try {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println(Thread.currentThread().getName());
                    TimeUnit.SECONDS.sleep(1);
                }catch (InterruptedException e){
                    System.out.println(e);
                }finally {
                    lock.releaseShared(1);
                }
            }
        }
    }
}
