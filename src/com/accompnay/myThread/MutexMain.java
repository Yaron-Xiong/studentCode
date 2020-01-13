package com.accompnay.myThread;

/**
 * @author Accompany
 * Date:2020/1/9
 */
public class MutexMain {
    private static Mutex mutex = new Mutex();
    static int a = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                mutex.lock();
                try {
                    for (int i1 = 0; i1 < 1000; i1++) {
                        a++;
                    }
                } finally {
                    mutex.unlock();
                }
            });
        }
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        System.out.println(a);
    }
}
