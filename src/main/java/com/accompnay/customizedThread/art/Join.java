package com.accompnay.customizedThread.art;

/**
 * @author Accompany
 * Date:2020/1/18
 * Thread.join():
 * 作用为当前线程需要等待Thread的运行结束后，在join之后运行
 * 也可以理解为当join的线程死亡之后才执行
 *
 * cur(当前线程)                                previous(需要等待的线程)
 * 1.执行previous.join()
 * 2.join()不断判断previous是否死亡
 * 3.如果previous不死亡，则cur线程wait(0)
 *
 * 部分源码：
 * while (isAlive()) {
 *     wait(0);
 * }
 * return ;
 *
 * 满足了经典等待通知范式
 * 1.加锁
 * 2.循环判断条件是否满足
 * 3.循环中等待，将cur放入等待队列
 * 4.操作结果
 */
public class Join {
    public static void main(String[] args) {
        Thread cur = Thread.currentThread();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new JoinThread(cur), String.valueOf(i));
            thread.start();
            cur = thread;
        }
        System.out.println(Thread.currentThread().getName()+"is ending");
    }

    static class JoinThread implements Runnable{
        Thread previous ;
        JoinThread(Thread previous){
            this.previous = previous;
        }
        @Override
        public void run() {
            try {
                previous.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"运行结束");
        }
    }
}
