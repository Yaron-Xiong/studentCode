package com.yaronxiong.thread.myThread;

public class volatileUnsafe {
    public static volatile int i = 0;
    public static class PlusTask implements Runnable{
        @Override
        public void run() {
            for (int k = 0;k<10000;k++){
                //因为 i++ 不具备原子性 ： 操作有
                //1.从主存读取i的值到TLAB
                //2.对进行i+1操作
                //3.将结果写回i
                i++;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] ts = new Thread[10];
        for (int i =0;i<ts.length;i++){
            ts[i] = new Thread(new PlusTask());
            ts[i].start();
        }
        for (Thread t : ts) {
            t.join();
        }
        System.out.println(i);
    }
}
