package com.accompnay.customizedThread.myConcurrent;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Author:Accompany
 * Date:2019/12/20
 * 循环栅栏
 */
public class CyclicBarrierDemo{

    public static class Soldier implements Runnable{
        private String name;
        private CyclicBarrier barrier;

        public Soldier(String name, CyclicBarrier barrier) {
            this.name = name;
            this.barrier = barrier;
        }

        @Override
        public void run() {
            try {
                //集合 在CyclicBarrier 的await()中会阻塞当前线程
                barrier.await();
                //等待所有士兵完成任务
                doWork();
                barrier.await();
            } catch (InterruptedException e) {
                System.out.println("*************响应中断");
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
        private void doWork(){
            try {
                Thread.sleep(new Random().nextInt(10)*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(this.name+"集合完毕打仗");
        }
    }

    public static class BarrierRun implements Runnable{
        //表示当前是等待集合还是执行任务
        Boolean flag ;
        int N;

        public BarrierRun(Boolean flag, int n) {
            this.flag = flag;
            N = n;
        }

        @Override
        public void run() {
            if (flag){
                System.out.println(N+"个士兵执行完任务");
            }else {
                System.out.println(N+"个士兵集合");
                flag=true;
            }
        }
    }

    public static void main(String[] args) {
        final int n = 10;
        Thread[] allSoldier = new Thread[n];
        boolean flag = false;
        CyclicBarrier barrier = new CyclicBarrier(n,new BarrierRun(flag,n));
        //开始执行
        System.out.println("开始集合");
        for (int i = 0; i < n; i++) {
            System.out.println("士兵"+i+"报道");
            allSoldier[i] = new Thread(new Soldier("士兵"+i,barrier));
            allSoldier[i].start();
            if (i==5){
                allSoldier[i].interrupt();
            }
        }
    }
}
