package com.accompnay.customizedThread.art;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Accompany
 * Java中通过自旋CAS实现计数器
 */
public class Counter {
    private AtomicInteger atomicI = new AtomicInteger(0);
    private int i  = 0;

    public static void main(String[] args) throws InterruptedException {
        final Counter counter = new Counter();
        List<Thread> threadList = new ArrayList<>(100);
        long start = System.currentTimeMillis();
        //创建100个线程 每个线程任务为计数自增1000次
        for (int i = 0; i < 100; i++) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i1 = 0; i1 < 1000; i1++) {
                        counter.safeCount();
                        counter.count();
                    }
                }
            });
            threadList.add(t);
        }
        //开启100个线程
        for (Thread thread : threadList) {
            thread.start();
        }
        //main线程等待100个线程执行完毕
        for (Thread thread : threadList) {
            thread.join();
        }
        System.out.println("线程安全计数器:"+counter.atomicI.get());
        System.out.println("非线程安全计数器:"+counter.i);
        System.out.println("执行耗时:"+(System.currentTimeMillis()-start));
    }

    /**
     * 使用CAS的线程安全计数器
     */
    private void safeCount(){
        for (;;){
            //获取最新值
            int i = atomicI.get();
            //使用CAS替换值，如果生成则退出
            boolean suc = atomicI.compareAndSet(i, i + 1);
            if (suc){
                break;
            }
        }
    }

    /**
     * 非线程安全计数器
     */
    private void count(){
        i++;
    }
}
