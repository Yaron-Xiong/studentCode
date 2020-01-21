package com.accompnay.customizedThread.threadPool;

/**
 * @author Accompany
 * Date:2020/1/21
 * 自定义线程池
 */
public interface ThreadPool<Job extends Runnable> {
    //执行一个Job，这个Job需要实现Runnable
    void execute(Job job);
    //关闭线程池
    void shutdown();
    //增加工作线程
    void addWorkers(int workerNum);
    //移除工作线程
    void removeWorker(int workerNum);
    // 得到正在工作线程数
    int getJobSize();
}
