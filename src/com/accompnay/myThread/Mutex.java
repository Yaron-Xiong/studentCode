package com.accompnay.myThread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Accompany
 * Date:2020/1/9
 * 如何实现一个锁？
 * 2.内部类继承AQS （模板设计模式）
 *
 * 3.内部类实现方法
 *      实现tryAcquire()方法、tryRelease()方法、isHeldExclusively()
 *
 * 4.外部调用acquire()方法、release()方法
 */
public class Mutex{

    private final Sync sync ;
    Mutex(){
        sync = new Sync();
    }

    /**
     * 同步器
     */
    private static class Sync extends AbstractQueuedSynchronizer{
        /**
         * 加锁
         * @param acquires 加锁次数
         */
        @Override
        protected boolean tryAcquire(int acquires) {
            final Thread current = Thread.currentThread();
            int c = getState();
            if (c==0){
                //表示没有其他线程占用
                if (compareAndSetState(0,acquires)){
                    //占用锁成功
                    setExclusiveOwnerThread(current);
                    return true;
                }
            }else if (current == getExclusiveOwnerThread()){
                //表示是当前线程占用了
                int nextc = c + acquires;
                //小于零 错误
                if (nextc <0)
                    throw new Error("Maximum lock count exceeded");
                //因为是当前线程占用了锁，所以可以不用CAS更新State
                setState(nextc);
                return true;
            }
            return false;
        }

        /**
         * 释放锁
         * @param releases 释放锁次数
         */
        @Override
        protected boolean tryRelease(int releases) {
            int c = getState() - releases;
            //如果非锁持有线程释放锁 则异常
            if (Thread.currentThread()!=getExclusiveOwnerThread())
                throw new IllegalMonitorStateException();
            boolean free = false;
            if (c==0){
                //释放成功
                free = true;
                //表示没有锁占用了
                setExclusiveOwnerThread(null);
            }
            //修改状态值，但是锁任然还在，所以只是修改值，不能唤醒其他线程
            setState(c);
            return free;
        }

        /**
         * 是否为当前线程
         */
        @Override
        protected boolean isHeldExclusively() {
            return getExclusiveOwnerThread() == Thread.currentThread();
        }


        /**
         * 在AQS中会调用tryAcquire()方法
         */
        final void lock() {
            acquire(1);
        }

        /**
         * 在AQS中会调用tryRelease()方法
         */
        final void unlock(){
            release(1);
        }
    }

    public void lock() {
        sync.lock();
    }


    public void unlock() {
        sync.unlock();
    }

}
