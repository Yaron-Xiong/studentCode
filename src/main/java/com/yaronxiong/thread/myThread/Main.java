package com.yaronxiong.thread.myThread;

/**
 * @author Accompany
 * Date:2019/12/26
 */
public class Main {
    private static final int a ;
    static {
        a = 2;
    }
    public static void main(String[] args) {

    }
    public static void method1(){
        synchronized (Main.class){
            System.out.println("1");
        }
    }
}
