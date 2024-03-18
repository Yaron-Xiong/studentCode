package com.yaronxiong.thread.art;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @author Accompany
 * Date:2020/1/21
 */
public class Mutex {
    static class Syn extends AbstractQueuedSynchronizer {

        /**
         * 获取锁
         */
        @Override
        protected boolean tryAcquire(int arg) {
            int state = getState();
            //判断是否未当前线程
            if (state==0||isHeldExclusively()){
                setState(state + arg);
                //表示没有其他线程获取锁
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        /**
         * 释放锁
         * 可以重入
         */
        @Override
        protected boolean tryRelease(int arg) {
            if (!isHeldExclusively()) {
                throw new IllegalMonitorStateException("状态异常");
            }
            int state = getState();
            setState(state - arg);
            if (state-arg<0){
                throw new IllegalArgumentException("释放锁次数过多");
            }else if (state-arg>0){
                return false;
            }
            return true;
        }

        /**
         * 是否未当前线程持有
         */
        @Override
        protected boolean isHeldExclusively() {
            return Thread.currentThread() == getExclusiveOwnerThread();
        }

        @Override
        protected int tryAcquireShared(int arg) {
            return super.tryAcquireShared(arg);
        }

        @Override
        protected boolean tryReleaseShared(int arg) {
            return super.tryReleaseShared(arg);
        }
    }

    final static Syn lock = new Syn();
    static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        List<Thread> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Work(),"work-"+i);
            thread.start();
            list.add(thread);
        }
        for (Thread thread : list) {
            thread.join();
        }
        System.out.println(count);
    }

    static class Work implements Runnable{
        @Override
        public void run() {
            lock.acquire(1);
            try {
                for (int i = 0; i < 100; i++) {
                    count++;
                }
            }finally {
                lock.release(1);
            }
        }
    }
}
