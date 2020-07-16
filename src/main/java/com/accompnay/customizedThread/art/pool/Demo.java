package com.accompnay.customizedThread.art.pool;

import java.util.concurrent.TimeUnit;

/**
 * @author Accompany
 */
public class Demo {
    public static void main(String[] args) throws InterruptedException {
        //创建线程池
        ThreadPoolTest pool = new ThreadPoolTest(5);
        //提交任务
        for (int i = 0; i < 10; i++) {
            pool.execute( ()->{
                try {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("姚远雄是世界上最帅的");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } );
        }
        TimeUnit.SECONDS.sleep(3);
        System.out.println("活动的线程数"+pool.getActiveCount());
        System.out.println("总线程数"+pool.getPoolSize());
        TimeUnit.SECONDS.sleep(2);
        System.out.println("=============添加5个线程=============");
        pool.addWorker(5);
        System.out.println("活动的线程数"+pool.getActiveCount());
        System.out.println("总线程数"+pool.getPoolSize());
        TimeUnit.SECONDS.sleep(2);
        System.out.println("=============移除5个线程=============");
        pool.removeWorker(5);
        System.out.println("活动的线程数"+pool.getActiveCount());
        System.out.println("总线程数"+pool.getPoolSize());
        TimeUnit.SECONDS.sleep(2);
        System.out.println("=============停止线程池=============");
        pool.shutdown();
        System.out.println("活动的线程数"+pool.getActiveCount());
        System.out.println("总线程数"+pool.getPoolSize());
    }
}
