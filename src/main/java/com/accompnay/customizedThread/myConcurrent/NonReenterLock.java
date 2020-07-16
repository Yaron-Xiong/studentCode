package com.accompnay.customizedThread.myConcurrent;

/**
 * 手写不可重复锁
 */
public class NonReenterLock implements Runnable{
    private static int i = 0;
    public static Lock lock = new Lock();
    @Override
    public void run() {
        for (int j = 0; j < 100; j++) {
            lock.lock();
            try {
                i++;
            }finally {
                lock.unLock();
            }
        }
    }


    public static class Lock {
        private static volatile boolean isLock = false;
        public synchronized void  lock(){
            while (isLock){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            isLock = true;
        }
        public synchronized void unLock(){
            isLock = false;
            notify();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new NonReenterLock());
        Thread t2 = new Thread(new NonReenterLock());
        t1.start();t2.start();
        t1.join();t2.join();
        System.out.println(i);
    }
}
