package com.example.pattern.singleton;

/**
 * 单例模式 静态内部类 懒汉模式：类初始化时，不会初始化该对象，真正需要使用的时候才会去创建该对象，具备懒加载功能。
 */
public class SingletonLazyTwo {
    /**
     * 1.将默认构造函数私有化
     */
    private SingletonLazyTwo(){}

    /**
     * 2.创建内部类，并且拥有的一个私有外部实例
     */
    private  static class SingletonLazy{
        private static  final SingletonLazyTwo singletonLazyTwo =new SingletonLazyTwo();
    }

    /**
     * 3.提供外部使用，当需要获得该类的实例，才去初始化内部类的静态实例（利用jvm初始化类的特性）
     * 虽然不会创建静态内部类的对象，但是其 Class 对象还是会被加载。
     * @return
     */
    public static SingletonLazyTwo getInstance(){
        return SingletonLazy.singletonLazyTwo;
    }
}
