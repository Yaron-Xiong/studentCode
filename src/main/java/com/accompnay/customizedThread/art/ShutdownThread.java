package com.accompnay.customizedThread.art;

import java.util.concurrent.TimeUnit;

/**
 * @author Accompany
 * Date:2020/1/18
 * 如何使用户线程安全停止工作？
 * 1.run方法执行完毕
 * 2.使用Thread.stop()方法 ->不推荐 具体原因看Deprecated.java 类似于抢占式
 * 3.线程自行响应中断信号，释放完资源后再停止线程  类似于非抢占式
 * <p>
 * 线程不安全的停止工作会存在什么问题？
 * 1.线程是否释放了占用的资源
 * <p>
 * 那么如何使用户线程安全停止工作？
 * 解决方案1：由用户自己写
 * 让用户线程主动响应中断信号，当线程执行完重要代码时，再响应中断信号，释放资源
 * 然后从系统退出，具体使用为设置一个boolean值，当boolean值发生变化时，便开始执行退出程序（释放资源）
 * <p>
 * 解决方案2：使用Thread方法
 * 使用Java提供的中断信号来完成用户线程安全停止工作
 */
public class ShutdownThread {
    public static void main(String[] args) throws InterruptedException {
        Solution one = new Solution();
        Thread t1 = new Thread(one, "one");
        t1.start();
        TimeUnit.SECONDS.sleep(1);
        one.myInterrupted();
        Solution two = new Solution();
        Thread t2 = new Thread(two, "two");
        t2.start();
        TimeUnit.SECONDS.sleep(1);
        t2.interrupt();
    }

    static class Solution implements Runnable {
        //手动模拟中断信号  为什么flag需要用volatile修饰呢？ 因为new是在main线程
        // 那么新线程会拉取副本到线程缓存中，导致one.myInterrupted失效，线程无法感知
        // 这时候需要将flag进行修饰
        volatile boolean flag = false;
        private int count = 0;

        @Override
        public void run() {
            while (!flag && !Thread.currentThread().isInterrupted()) {
                count++;
            }
            System.out.println("代码块停止" + count);
        }

        public void myInterrupted() {
            flag = true;
        }
    }
}
