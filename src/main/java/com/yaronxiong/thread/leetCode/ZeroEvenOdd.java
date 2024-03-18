package com.yaronxiong.thread.leetCode;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * @author Accompany
 * LeetCode 1116 打印0和奇偶数
 * 假设有这么一个类：
 * <p>
 * class ZeroEvenOdd {
 *   public ZeroEvenOdd(int n) { ... }      // 构造函数
 * public void zero(printNumber) { ... }  // 仅打印出 0
 * public void even(printNumber) { ... }  // 仅打印出 偶数
 * public void odd(printNumber) { ... }   // 仅打印出 奇数
 * }
 * 相同的一个 ZeroEvenOdd 类实例将会传递给三个不同的线程：
 * <p>
 * 线程 A 将调用 zero()，它只输出 0 。
 * 线程 B 将调用 even()，它只输出偶数。
 * 线程 C 将调用 odd()，它只输出奇数。
 * 每个线程都有一个 printNumber 方法来输出一个整数。请修改给出的代码以输出整数序列 010203040506... ，其中序列的长度必须为 2n。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出："0102"
 * 说明：三条线程异步执行，其中一个调用 zero()，另一个线程调用 even()，最后一个线程调用odd()。正确的输出为 "0102"。
 * 示例 2：
 * <p>
 * 输入：n = 5
 * 输出："0102030405"
 */
public class ZeroEvenOdd {
    private volatile int n;
    private volatile int count = 1;
    private Semaphore zero = new Semaphore(1);
    private Semaphore even = new Semaphore(0);
    private Semaphore odd = new Semaphore(0);

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        while (count <= n) {
            zero.acquire();
            if (count>n) {
                even.release();
                odd.release();
                break;
            }
            //printNumber.accept(0);
            System.out.print(0);
            if (count % 2 == 0) {
                even.release();
            } else {
                odd.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        while (count <= n) {
            even.acquire();
            if (count>n) break;
            //printNumber.accept(count++);
            System.out.print(count++);
            zero.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        while (count <= n) {
            odd.acquire();
            if (count>n) break;
            //printNumber.accept(count++);
            System.out.print(count++);
            zero.release();
        }
    }

    public static void main(String[] args) {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(2);
        Runnable r1 = () -> {
            try {
                zeroEvenOdd.zero(null);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Runnable r2 = () -> {
            try {
                zeroEvenOdd.even(null);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Runnable r3 = () -> {
            try {
                zeroEvenOdd.odd(null);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        new Thread(r1).start();
        new Thread(r2).start();
        new Thread(r3).start();
    }
}
