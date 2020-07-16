package com.accompnay.customizedThread.art;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author Accompany
 * Date:2020/1/22
 * 读写锁：
 * 1.读锁为共享锁，可以多个线程同时执行，但是其他线程都只能用读锁
 * 2.写锁为排它锁，同一时刻只能有一个线程持有写锁，有写锁的线程 可以继续持有读锁（锁降级）
 *
 * 好处：
 * 读数据可以大量线程并发执行，因为读数据并不会改变数据，这也就不会发生线程安全问题
 *
 * 坏处
 * 如果系统钟存在很多读线程的话，那么写的线程将会一直阻塞，导致无法将数据更新至最新
 *
 * 所以在使用的时候需要注意：
 * 系统中如果写发生的概率很低的话，那么可以使用读写锁
 * 要不然使用读写锁的话，会存在很大的线程安全问题
 */
public class CacheReadWriteLock {
    private static Map<Integer,String> cache = new HashMap<>();
    private static ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock(true);
    private static ReentrantReadWriteLock.ReadLock r = reentrantReadWriteLock.readLock();
    private static ReentrantReadWriteLock.WriteLock w = reentrantReadWriteLock.writeLock();
    private static int count = 0;
    public static void main(String[] args) {
        Thread write = new Thread(new WriteWorker());
        write.start();
        for (int i = 0; i < 10; i++) {
            Thread read = new Thread(new ReadWorker());
            read.start();
        }
    }

    static class WriteWorker implements Runnable{

        @Override
        public void run() {
            while (true){
                try {
                    w.lock();
                    TimeUnit.SECONDS.sleep(1);
                    count++;
                    System.out.println("写入操作执行中");
                    cache.put(1,"count:"+count);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    w.unlock();
                }
            }
        }
    }

    static class ReadWorker implements Runnable{

        @Override
        public void run() {
            while (true){
                try {
                    r.lock();
                    TimeUnit.SECONDS.sleep(1);
                    String s = cache.get(1);
                    System.out.println("读锁获取到了"+s);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    r.unlock();
                }
            }
        }
    }
}
