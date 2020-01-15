package com.accompnay.customizedThread.myThread;

public class GoodSuspend2 {
    private static final Person person = new Person("张三",15);
    public static class WriteObjectThread extends Thread{
        private volatile Boolean isSuspend = false;
        public void suspendMe() {
            System.out.println("发起挂起请求");
            this.isSuspend = true;
        }
        public void resumeMe(){
            this.isSuspend = false;
            synchronized (this){
                notify();
            }
        }

        @Override
        public void run() {
            while (true){
                while (isSuspend){
                    synchronized (this){
                        try {
                            System.out.println("开始被挂起");
                            wait();
                        } catch (InterruptedException e) {
                            System.out.println("睡觉被打断");
                            e.printStackTrace();
                            break;
                        }
                    }
                }
                synchronized (person){
                    int i = (int) (System.currentTimeMillis()/1000);
                    System.out.println("正在写...");
                    person.setName(String.valueOf(i));
                    person.setAge(i);
                }
                Thread.yield();
            }
        }
    }
    public static class ReadObjectThread extends Thread{
        @Override
        public void run() {
            while (true){
                synchronized (person){
                    System.out.println(person);
                }
                Thread.yield();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        WriteObjectThread t1 = new WriteObjectThread();
        ReadObjectThread t2 = new ReadObjectThread();
        t1.start();
        t2.start();
        System.out.println("t1 suspend ...!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        Thread.sleep(10);
        t1.suspendMe();
        System.out.println("t1 suspend 10s!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        t1.interrupt();
        Thread.sleep(5000);
        t1.resumeMe();
    }
}
