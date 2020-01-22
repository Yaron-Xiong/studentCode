package com.accompnay.customizedThread.art;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Accompany
 * Date:2020/1/22
 * Condition: 可以使用Condition中的wait() 和notify() 方法实现 线程间的等待通知机制
 *
 * 案例：使用Condition有界队列
 * 当队列满的时候不能加入
 * 当队列为空的时候不能取
 */
public class BoundedQueue<T> {
    private static ReentrantLock lock = new ReentrantLock();
    private static Condition empty = lock.newCondition();
    private static Condition full = lock.newCondition();
    private volatile int count;
    private static volatile Object [] data;
    public BoundedQueue(){
        data = new Object[10];
    }

    //向数组中加入数据
    public void add(T t){
        //加锁后再进行操作
        lock.lock();
        try {
            //这里采用循环的目的是怕数据被其他线程修改了 ，唤醒之后再判断异常
            while (count==data.length-1){
                System.out.println(Thread.currentThread().getName()+"队列为满不能加入 睡眠");
                //表示队列满了
                full.awaitUninterruptibly();
            }
            //赋值
            data[count++] = t;
            //唤醒获取线程
            empty.signal();
        }  finally {
            lock.unlock();
        }
    }

    public Object removeItem(){
        Object obj = null;
        //加锁后操作
        lock.lock();
        try {
            while (count==0){
                //表示不存在值了
                System.out.println(Thread.currentThread().getName()+"队列为空不能删除 睡眠");
                empty.awaitUninterruptibly();
            }
            //删除最后一个加入的值
            obj = data[count];
            data[count--] = null;
            //因为删除了元素，那么可以唤醒因为队列满而不能添加元素的线程
            full.signal();
        }finally {
            lock.unlock();
        }
        return obj;
    }

    private static BoundedQueue<Object> queue = new BoundedQueue<>();

    public static void main(String[] args) {
        Thread remove = new Thread(new removeElementWorker(),"removeThread");
        remove.start();
        for (int i = 0; i < 10; i++) {
            Thread addWorker = new Thread(new addElementWorker(),"addThread_"+i);
            addWorker.start();
        }
    }

    private static volatile int element = 0;
    private static ReentrantLock elmentLock = new ReentrantLock();
    static class addElementWorker implements Runnable{
        @Override
        public void run() {
            while (true){
                elmentLock.lock();
                try {
                    queue.add(element += 1);
                    System.out.println("添加元素"+element);
                }finally {
                    elmentLock.unlock();
                }
            }
        }
    }

    static class removeElementWorker implements Runnable{
        @Override
        public void run() {
            while (true){
                Object item = queue.removeItem();
                System.out.println("删除元素::"+item);
            }
        }
    }
}
