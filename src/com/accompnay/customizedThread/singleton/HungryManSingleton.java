package com.accompnay.customizedThread.singleton;

/**
 * @author Accompany
 * Date:2019/12/26
 * 饿汉式单例
 * 在类初始化的时候就会创建对象
 * 以空间换时间
 */
public class HungryManSingleton {
    private static HungryManSingleton INSTANCE = new HungryManSingleton();
    private HungryManSingleton(){}
    public static HungryManSingleton getInstance(){
        return INSTANCE;
    }
}
