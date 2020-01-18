package com.accompnay.customizedThread.myConcurrent;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Accompany
 * Author:
 * 可重入锁响应中断
 * 演示两个线程争夺两个资源，当一个线程被中断后放弃资源
 * Date:2019/12/18
 */
public class IntLock implements Runnable {
    private ReentrantLock r1 = new ReentrantLock();
    private ReentrantLock r2 = new ReentrantLock();

    @Override
    public void run() {
        try {
            if (Thread.currentThread().getName().equals("1")){
                //先获取r1 再获取r2
                System.out.println(Thread.currentThread().getName()+"获取r1");
                r1.lockInterruptibly();
                Thread.sleep(200);
                System.out.println(Thread.currentThread().getName()+"获取r2");
                r2.lockInterruptibly();
                System.out.println(Thread.currentThread().getName()+"执行完毕");
            }else{
                //先获取r1 再获取r2
                System.out.println(Thread.currentThread().getName()+"获取r2");
                r2.lockInterruptibly();
                Thread.sleep(200);
                System.out.println(Thread.currentThread().getName()+"获取r1");
                r1.lockInterruptibly();
                System.out.println(Thread.currentThread().getName()+"执行完毕");
            }
        } catch (InterruptedException e) {
            //响应中断信号
            System.out.println(Thread.currentThread().getName()+"响应中断");
        }finally {
            //释放锁
            if (r1.isHeldByCurrentThread()){
                //是否被当前线程持有
                System.out.println(Thread.currentThread().getName()+"释放r1");
                r1.unlock();
            }
            if (r2.isHeldByCurrentThread()){
                System.out.println(Thread.currentThread().getName()+"释放r2");
                r2.unlock();
            }
        }
    }

    public static void main(String[] args) {
        IntLock inTest = new IntLock();
        Thread t1 = new Thread(inTest,"1");
        Thread t2 = new Thread(inTest, "2");
        t1.start();
        t2.start();
        t1.interrupt();
    }


}
