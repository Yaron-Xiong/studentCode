package com.yaronxiong.thread.art.pool;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author Accompany
 */
public class ThreadPoolTest implements ThreadPool {
    public ThreadPoolTest(int corePoolSize) {
        workerQueue = new LinkedBlockingQueue<>();
        threads = new ArrayList<>();
        addWorker(corePoolSize);
    }

    /**
     * 存储任务队列
     * 线程安全
     */
    LinkedBlockingQueue<Runnable> workerQueue;
    /**
     * 存储工作线程
     */
    List<Worker> threads;

    /**
     * 工作线程
     */
    class Worker extends Thread {
        private Runnable command;
        private int runState;

        public Worker(String name, int runState) {
            super(name);
            this.runState = runState;
        }

        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted() && (command = getWork()) != null) {
                try {
                    setState(1);
                    command.run();
                } finally {
                    setState(0);
                }
            }
        }

        /**
         * 获取任务
         */
        public Runnable getWork() {
            Runnable work = null;
            try {
                work = workerQueue.take();
            } catch (InterruptedException e) {
                System.out.println("线程响应中断===》停止获取任务");
            }
            return work;
        }

        /**
         * 获取工作线程的状态
         * 1：表示运行
         * 0：表示停止
         */
        public int getRunState() {
            return runState;
        }

        /**
         * 设置工作线程的状态
         */
        private void setState(int state) {
            this.runState = state;
        }
    }

    @Override
    public void execute(Runnable command) {
        //任务添加到任务队列
        boolean isSuccess = workerQueue.offer(command);
        if (!isSuccess) {
            throw new RuntimeException("提交任务失败");
        }
    }

    @Override
    public void shutdown() {
        for (Thread thread : threads) {
            thread.interrupt();
        }
    }

    @Override
    public void addWorker(int mun) {
        for (int i = 0; i < mun; i++) {
            Worker worker = new Worker("Thread-" + threads.size(), 0);
            worker.start();
            threads.add(worker);
        }
    }

    @Override
    public void removeWorker(int mun) {
        if (mun>threads.size()){
            throw new RuntimeException("移除线程数超过最大值");
        }
        int count = 0;
        Iterator<Worker> iterator = threads.iterator();
        while (iterator.hasNext()){
            Worker worker = iterator.next();
            worker.interrupt();
            iterator.remove();
            count++;
            if (count==mun){
                break;
            }
        }
    }

    @Override
    public int getActiveCount() {
        int count = 0;
        for (Worker worker : threads) {
            count = worker.getRunState()==1?count+1:count;
        }
        return count;
    }

    @Override
    public int getPoolSize() {
        return threads.size();
    }
}
