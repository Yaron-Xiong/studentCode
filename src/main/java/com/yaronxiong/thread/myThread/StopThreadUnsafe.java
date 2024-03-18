package com.yaronxiong.thread.myThread;

public class StopThreadUnsafe {
    public static User user = new User();
    public static class User{
        private Integer id;
        private String name;
        public User(){
            id = 0;
            name = "0";
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class ChangeObjectThread extends Thread{
        boolean flag = false;
        public void setFlag (boolean flag){
            System.out.println("停止");
            this.flag = flag;
        }
        @Override
        public void run() {
            while (true){
                //采用外部调用setFlag做到具体位置停止线程
                if (flag){
                    System.out.println("stop this Thread");
                    break;
                }
                synchronized (user){
                    int v = (int) (System.currentTimeMillis()/1000);
                    //id与name应该是一致的
                    user.setId(v);
                    //在线程执行到这里发生Thread.stop()导致只对id赋值 出现数据异常
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    user.setName(String.valueOf(v));
                }
                //和别的线程竞争
                Thread.yield();
            }
        }
    }

    public static class ReadObjectThread implements Runnable{
        @Override
        public void run() {
            while (true){
                synchronized (user){
                    if (!user.getId().equals(Integer.parseInt(user.getName()))){
                        System.out.println("发生诡异现象 :userId"+user.getId()+"  userName"+user.getName());
                    }
                }
                Thread.yield();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(new ReadObjectThread()).start();
        while (true){
            ChangeObjectThread thread = new ChangeObjectThread();
            thread.start();
            Thread.sleep(150);
            //用标记来替换stop造成的不知什么时候停断的问题
            thread.setFlag(true);
        }
    }
}
