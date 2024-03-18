package com.yaronxiong.thread.art.pool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Accompany
 */
public class Demo2 {
    private final ConcurrentHashMap<Object, Future<String>> taskCache =
            new ConcurrentHashMap<>();
    private String executionTask(final String taskName) throws ExecutionException, InterruptedException, BrokenBarrierException {
        while (true){
            //获取任务
            Future<String> future = taskCache.get(taskName);
            //如果任务是空的话就创建任务
            if (future==null){
                Callable<String> task = ()-> {
                    TimeUnit.SECONDS.sleep(5);
                    System.out.println(Thread.currentThread().getName()+"线程run()执行完毕");
                    return taskName;
                } ;
                FutureTask<String> futureTask = new FutureTask<>(task);
                //如果缓存中存在值，就不替换，并且返回对应Key的值
                //这个会发生的原因是多线程环境下的不安全性
                future = taskCache.putIfAbsent(taskName,futureTask);
                //当没有线程执行过的时候执行任务
                if (future==null){
                    future = futureTask;
                    futureTask.run();
                }
            }
            try {
                System.out.println(Thread.currentThread().getName()+"获取返回结果");
                String result = future.get();
                System.out.println(Thread.currentThread().getName()+"线程返回");
                return result;
            } catch (CancellationException e) {
                taskCache.remove(taskName,future);
            }
        }
    }
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService  = new ThreadPoolExecutor(2,2,0L, TimeUnit.SECONDS,new ArrayBlockingQueue<>(2));
        Demo2 demo2 = new Demo2();
        String taskName = "abc";
        //提交同一个任务
        Callable<String> callable = ()->demo2.executionTask(taskName);
        for (int i = 0; i < 2; i++) {
            Future<String> future = executorService.submit(callable);
        }
    }

}
