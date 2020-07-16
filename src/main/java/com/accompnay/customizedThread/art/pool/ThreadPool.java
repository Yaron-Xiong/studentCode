package com.accompnay.customizedThread.art.pool;

/**
 * @author Accompany
 * 线程池接口
 */
public interface ThreadPool {
    //执行一个任务
    void execute(Runnable command);
    //关闭线程池
    void shutdown();
    //增加工作线程
    void addWorker(int mun);
    //移除工作线程
    void removeWorker(int mun);
    //获取正在工作的线程数
    int getActiveCount();
    //获取线程池中的全部线程大小
    int getPoolSize();
}
