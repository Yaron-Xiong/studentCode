package com.yaronxiong.thread.myThread;

public class StopThread {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(){
            @Override
            public void run() {
                super.run();
                while (true){
                    if (Thread.currentThread().isInterrupted()){
                        System.out.println("停止执行");
                        break;
                        //Thread.interrupted();
                    }
                    if (!this.isInterrupted()){
                        try {
                            System.out.println("睡眠");
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            //Thread.currentThread().interrupt();
                            System.out.println("睡眠被打断"+"  "+Thread.currentThread().isInterrupted());
                            //Thread.currentThread().interrupt();
                            e.printStackTrace();
                        }

                    }
                }
            }
        };
        t1.start();
        Thread.sleep(500);
        //t1.interrupt();
        //Thread.sleep(500);
        //t1.interrupt();
    }

}
