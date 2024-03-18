package com.yaronxiong.thread.singleton;

/**
 * @author Accompany
 * Date:2019/12/26
 * 静态内部类机制
 * 在类加载的时候完成对单例的初始化工作
 * 使用类的加载机制来保证单例的安全性
 */
public class StaticInnerClassSingleton {
    private StaticInnerClassSingleton(){}
    private static class SingletonInstance{
        private SingletonInstance(){}
        private static StaticInnerClassSingleton singleton = new StaticInnerClassSingleton();
    }
    public static StaticInnerClassSingleton getInstance(){
        return SingletonInstance.singleton;
    }
}
