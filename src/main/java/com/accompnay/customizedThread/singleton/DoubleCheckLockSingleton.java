package com.accompnay.customizedThread.singleton;

/**
 * @author Accompany
 * Date:2019/12/26
 * DCL双检查，设计单例模式
 * 其中会出现DCL创建对象过程中的指令重排在多线程下的不安全问题
 * 所以需要采用Volatile的机制保证创建对象是原子的
 */
public class DoubleCheckLockSingleton {
    private static volatile DoubleCheckLockSingleton singleton = null;
    private DoubleCheckLockSingleton(){}
    public static DoubleCheckLockSingleton getInstance(){
        if (singleton==null){
            synchronized (DoubleCheckLockSingleton.class){
                //DCL会存在一个很经典的问题 所以需要加volatile保证123步骤不会重排
                //在创建对象的过程会分成三步
                //1.分配内存空间
                //2.创建对象
                //3.将对象的引用指向分配的内存空间
                //注解：3会依赖1、2会依赖1、3不会依赖2.这就导致2.3指令可能会发生指令重排
                // 导致singleton==null不成立但是又没有创建对象，出现多线程不安全问题
                if (singleton == null){
                    singleton = new DoubleCheckLockSingleton();
                }
            }
        }
        return singleton;
    }
}
