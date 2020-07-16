package com.accompnay.customizedThread.art;

import java.util.concurrent.TimeUnit;

/**
 * @author Accompany
 * Date:2020/1/18
 * ThreadLocal:线程独属变量，可以用于存储线程独自的变量
 *
 * 原理：
 * 1.ThreadLocal内部维护了一个Map集合
 * 2.Map集合Key-Value，key为线程实例，value为Entity  也就是set的值或者是初始化的值
 *
 * 需要注意：
 * 1.ThreadLocal:在每个线程会有自己独属一份
 * 2.第一次调用ThreadLocal.get()方法的时候，如果从未调用过set()方法，那么就会走一次初始化方法
 *
 */
public class ThreadLocalTest {
    ThreadLocal<Long> local = new ThreadLocal<Long>();
    public static void main(String[] args) throws InterruptedException {
        ThreadLocalTest test = new ThreadLocalTest();
        test.set();
        System.out.println("开始时间"+System.currentTimeMillis());
        TimeUnit.SECONDS.sleep(2);
        System.out.println("运行时间"+test.end());
    }

    public final void set(){
        local.set(System.currentTimeMillis());
    }

    public long end(){
        return System.currentTimeMillis() - local.get();
    }
}
