package com.accompnay.myConcurrent;

import java.util.concurrent.locks.ReentrantLock;

/**Accompany
 * Author:
 * 可重入锁响应中断
 * Date:2019/12/18
 */
public class IntLock implements  Runnable{
    private static ReentrantLock lock1 = new ReentrantLock();
    private static ReentrantLock lock2 = new ReentrantLock();
    int lock ;

    public IntLock(int lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            if (lock ==1){
                lock1.lockInterruptibly();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock2.lockInterruptibly();
                System.out.println("线程1执行完毕");
            }else {
                lock2.lockInterruptibly();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock1.lockInterruptibly();
                System.out.println("线程2执行完毕");
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            if (lock1.isHeldByCurrentThread()){
                lock1.unlock();
            }
            if (lock2.isHeldByCurrentThread()){
                lock2.unlock();
            }
            System.out.println("线程退出");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new IntLock(1));
        Thread t2 = new Thread(new IntLock(2));
        t1.start();
        t2.start();
        Thread.sleep(1000);
        t2.interrupt();
    }
}
