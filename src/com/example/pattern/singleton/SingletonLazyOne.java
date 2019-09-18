package com.example.pattern.singleton;

/**
 * 单例模式 双重检测 （因为JVM本身重排序的原因，可能会出现多次的初始化）懒汉模式：类初始化时，不会初始化该对象，真正需要使用的时候才会去创建该对象，具备懒加载功能。
 */
public class SingletonLazyOne {
    /**
     * 1.将默认构造函数私有化
     */
    private SingletonLazyOne(){}

    /**
     * 2.创建类的唯一私有实例。  volatile 修饰的成员变量可以确保多个线程都能够正确处理
     */
    private static volatile SingletonLazyOne instance;

    /**
     * 3.提供外部使用，当需要获得该类的实例，判断是否已存在，若无则进行创建该实例。
     * 当然代码中使用了锁就会有额外的开销 对性能有一定的影响
     * @return
     */
    public static SingletonLazyOne getInstance(){
        if (instance==null){
            synchronized (instance) {
                if(instance==null){
                    instance = new SingletonLazyOne();
                }
            }
        }
        return instance;
    }
}
