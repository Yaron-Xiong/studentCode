package com.accompnay.customizedThread.threadPool;


import javafx.concurrent.Worker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Accompany
 * Date:2020/1/21
 * 线程池，内部维护了一个线程数组
 * 外部调用execute执行
 */
public class DefaultThreadPool<Job extends Runnable> implements ThreadPool<Job> {
    //最大线程数
    private final static int MAX_WORKER_NUMBER = 10;
    //默认线程数
    private final static int DEFAULT_WORKER_NUMBER = 5;
    //最小线程数
    private final static int MIN_WORKER_NUMBER = 1;
    //任务数组 安全问题
    private final LinkedList<Job> jobs = new LinkedList<>();
    //工作线程 安全问题
    private final List<Worker> workerList = Collections.synchronizedList(new ArrayList<>());
    //线程ID
    private AtomicLong threadNum = new AtomicLong();
    //工作线程数 安全问题
    private int workerNumber = DEFAULT_WORKER_NUMBER;

    //线程池初始化
    public DefaultThreadPool() {
        initThreadPool(DEFAULT_WORKER_NUMBER);
    }

    public void initThreadPool(int workerNumber){
        for (int i = 0; i < workerNumber; i++) {
            Worker worker = new Worker();
            workerList.add(worker);
            Thread thread = new Thread(worker,"ThreadPool--Worker-"+threadNum.incrementAndGet());
            thread.start();
        }
    }

    @Override
    public void execute(Job job) {
        if (job!=null){
            synchronized (jobs){
                jobs.add(job);
                //因为工作线程会因为job==0的时候睡眠，需要唤醒
                // 不能使用notifyAll的原因是 会造成大批量线程抢占job然后又陷入睡眠状态
                jobs.notify();
            }
        }
    }

    @Override
    public void shutdown() {
        for (Worker worker : workerList) {
            worker.shutdown();
        }
    }

    @Override
    public void addWorkers(int workerNum) {
        synchronized (jobs){
            if (workerNum<=0){
                throw new IllegalArgumentException("添加工作线程数不能小于0");
            }
            workerNum = workerNumber>MAX_WORKER_NUMBER?MAX_WORKER_NUMBER:workerNumber<MIN_WORKER_NUMBER?MIN_WORKER_NUMBER:workerNum;
            workerNumber+=workerNum;
            initThreadPool(workerNum);
        }
    }

    @Override
    public void removeWorker(int workerNum) {
        //在移除线程的时候 任务不能执行，因为可能会线程未初始化
        synchronized (jobs){
            if (workerNum<0||workerNum>workerNumber){
                throw new IllegalArgumentException("添加工作线程数不能小于0");
            }
            int count = workerNum;
            while (count>0){
                Worker worker = workerList.get(count - 1);
                if (workerList.remove(worker)){
                    worker.shutdown();
                    count--;
                }
            }
            workerNumber-=workerNum;
        }
    }

    @Override
    public int getJobSize() {
        return jobs.size();
    }

    class Worker implements  Runnable{
        // 是否工作 默认开启
        private volatile boolean running = true;
        @Override
        public void run() {
            while (running){
                //表示开始工作
                Job job = null;
                synchronized (jobs){
                    //对工作队列进行加锁访问
                    while (jobs.isEmpty()){
                        try {
                            jobs.wait();
                        } catch (InterruptedException e) {
                            //因为线程从睡眠中唤醒 中断信号会从  false -> true -> false
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }
                    job = jobs.removeFirst();
                    if (job!=null){
                        try {
                            job.run();
                        }catch (Exception e){
                            System.out.println(Thread.currentThread().getName() + "任务发生异常");
                        }
                    }
                }
            }
        }
        public void shutdown(){
            running = false;
        }
    }
}
