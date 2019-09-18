package com.example.pattern.singleton;

/**
 * 单例模式 饿汉模式:类初始化的时候，会立即加载该对象，线程天生安全，调用效率高。
 */
public class SingletonHunger {
    /**
     * 1.将构造函数私有化，不允许外部直接创建对象
     */
    private SingletonHunger() {
    }

    /**
     * 2.创建类的唯一私有实例,一旦加载类就进行初始化实例
     */
    private static final SingletonHunger instance = new SingletonHunger();

    /**
     * 3.提供外部使用
     * @return
     */
    public static SingletonHunger getInstance() {
        return instance;
    }
}
