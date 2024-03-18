package com.yaronxiong.thread.myThread;

public class JoinMain {
    public static int i = 0;
    public static class AddTread extends Thread{
        @Override
        public void run() {
            for (i = 0;i<100;i++){
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"  "+i);
            }
        }

        public AddTread(String name) {
            super(name);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        AddTread t1 = new AddTread("t1");
        AddTread t2 = new AddTread("t2");
        t1.start();
        t2.start();
        System.out.println("main 线程启动");
        System.out.println("i的值"+i++);
        System.out.println("main 结束");
        Thread.sleep(500);
        System.out.println("最终i的值"+i);
    }
}
