package com.accompnay.customizedThread.leetCode;

import java.util.concurrent.Semaphore;

/**
 * @author Accompany
 * LeetCode 1115  交替打印
 * 我们提供一个类：
 * <p>
 * class FooBar {
 * public void foo() {
 *     for (int i = 0; i < n; i++) {
 *       print("foo");
 *     }
 * }
 * <p>
 * public void bar() {
 *     for (int i = 0; i < n; i++) {
 *       print("bar");
 *     }
 * }
 * }
 * 两个不同的线程将会共用一个 FooBar 实例。其中一个线程将会调用 foo() 方法，另一个线程将会调用 bar() 方法。
 * <p>
 * 请设计修改程序，以确保 "foobar" 被输出 n 次。
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 1
 * 输出: "foobar"
 * 解释: 这里有两个线程被异步启动。其中一个调用 foo() 方法, 另一个调用 bar() 方法，"foobar" 将被输出一次。
 * 示例 2:
 * <p>
 * 输入: n = 2
 * 输出: "foobarfoobar"
 * 解释: "foobar" 将被输出两次。
 *
 * 可以加锁
 * 可以不加锁
 *
 * 参考任务执行时间长短来决定
 */
public class FooBar {
    private int n;
    private volatile boolean flag = false;
    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            //使用无锁，但是存在自旋耗时，适用于任务执行时间短
            while (flag){
                Thread.yield();
            }
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            flag = !flag;
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            while (!flag){
                Thread.yield();
            }
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            flag = !flag;
        }
    }

    public static void main(String[] args) {
        FooBar fooBar = new FooBar(10);
        Runnable foot = ()->{
            try {
                fooBar.foo( ()->{
                    System.out.print("foot");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Runnable bar = ()->{
            try {
                fooBar.bar( ()->{
                    System.out.print("bar");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Thread t1 = new Thread(foot);
        Thread t2 = new Thread(bar);
        t2.start();
        t1.start();
    }
}
