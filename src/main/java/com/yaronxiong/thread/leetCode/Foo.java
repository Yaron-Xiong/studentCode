package com.yaronxiong.thread.leetCode;

import java.util.concurrent.Semaphore;

/**
 * @author Accompany
 * LeetCode 1114题 按序打印
 * 我们提供了一个类：
 * <p>
 * public class Foo {
 * public void one() { print("one"); }
 * public void two() { print("two"); }
 * public void three() { print("three"); }
 * }
 * 三个不同的线程将会共用一个 Foo 实例。
 * <p>
 * 线程 A 将会调用 one() 方法
 * 线程 B 将会调用 two() 方法
 * 线程 C 将会调用 three() 方法
 * 请设计修改程序，以确保 two() 方法在 one() 方法之后被执行，three() 方法在 two() 方法之后被执行。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 输出: "onetwothree"
 * 解释:
 * 有三个线程会被异步启动。
 * 输入 [1,2,3] 表示线程 A 将会调用 one() 方法，线程 B 将会调用 two() 方法，线程 C 将会调用 three() 方法。
 * 正确的输出是 "onetwothree"。
 * 示例 2:
 * <p>
 * 输入: [1,3,2]
 * 输出: "onetwothree"
 * 解释:
 * 输入 [1,3,2] 表示线程 A 将会调用 one() 方法，线程 B 将会调用 three() 方法，线程 C 将会调用 two() 方法。
 * 正确的输出是 "onetwothree"。
 */
public class Foo {
    private Semaphore two = new Semaphore(0);
    private Semaphore three = new Semaphore(0);

    public Foo() {
    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        two.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        two.acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        three.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        three.acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }

    public static void main(String[] args) {
        Foo foo = new Foo();
        Runnable task1 = () -> {
            try {
                Runnable runnable = () -> System.out.println("one");
                foo.first(runnable);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Runnable task2 = () -> {
            try {
                Runnable runnable2 = () -> System.out.println("two");
                foo.second(runnable2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Runnable task3 = () -> {
            try {
                Runnable runnable3 = () -> System.out.println("third");
                foo.third(runnable3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        new Thread(task2).start();
        new Thread(task3).start();
        new Thread(task1).start();

    }
}
