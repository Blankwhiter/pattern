package com.example.pattern;

/**
 * 单例模式 懒汉模式
 */
public class SingletonLazy {
    //1.将默认构造函数私有化
    private SingletonLazy(){}

    //2.创建类的唯一私有实例
    private static SingletonLazy instance;

    //3.提供外部使用，当需要获得该类的实例，判断是否已存在，若无则进行创建该实例
    public static SingletonLazy getInstance(){
        if (instance!=null){
            instance = new SingletonLazy();
        }
        return instance;
    }
}
