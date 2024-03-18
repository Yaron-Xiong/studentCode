package com.yaronxiong.thread.singleton;

/**
 * @author Accompany
 * Date:2019/12/26
 * 懒汉式
 * 在方法上进行加锁，避免重复创建实例
 * 但是每次请求方法都会获取锁，消耗时间
 */
public class LockSingleton {
    private static LockSingleton singleton = null;
    private LockSingleton(){}
    public static synchronized LockSingleton getInstance(){
        if (singleton==null){
            singleton = new LockSingleton();
        }
        return singleton;
    }
}
