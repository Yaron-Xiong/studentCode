package com.accompnay.seftest;

import java.net.URISyntaxException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Test7 {
    public static void main(String[] args) throws URISyntaxException, InterruptedException {

        Semaphore semaphore = new Semaphore(0);
        Task task = new Task();
        new Thread(task).start();

        TimeUnit.SECONDS.sleep(5);
        synchronized (lock) {
            lock.notify();
        }
    }

    private static final Object lock = new Object();

    public static class Task implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                try {
                    System.out.println("开始执行");
                    lock.wait();
                    System.out.println("结束");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

}
