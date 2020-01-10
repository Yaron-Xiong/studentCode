package com.accompnay.myConcurrent;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Author:Accompany
 * Date:2019/12/18
 * 尝试获取锁
 */
public class TryLock implements Runnable{
    private static ReentrantLock lock1 = new ReentrantLock();
    private static ReentrantLock lock2 = new ReentrantLock();
    int lock ;

    public TryLock(int lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        if (lock==1){
            while (true){
                if (lock1.tryLock()){
                    try {
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if (lock2.tryLock()){
                            try {
                                System.out.println("线程1done");
                                break;
                            }finally {
                                lock2.unlock();
                                System.out.println("线程2释放lock2");
                            }
                        }else {
                            System.out.println("线程1没有拿到lock2");
                        }
                    }finally {
                        lock1.unlock();
                        System.out.println("线程1释放lock1");
                    }
                }
            }
        }else {
            while (true){
                if (lock2.tryLock()){
                    try {
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if (lock1.tryLock()){
                            try {
                                System.out.println("线程2done");
                                break;
                            }finally {
                                System.out.println("线程2释放lock1");
                                lock1.unlock();
                            }
                        }
                    }finally {
                        System.out.println("线程2释放lock2");
                        lock2.unlock();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new TryLock(1));
        Thread t2 = new Thread(new TryLock(2));
        t1.start();t2.start();
    }
}
