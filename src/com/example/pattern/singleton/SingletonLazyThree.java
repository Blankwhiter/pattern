package com.example.pattern.singleton;

/**
 * 单例模式 枚举 懒汉模式：类初始化时，不会初始化该对象，真正需要使用的时候才会去创建该对象，具备懒加载功能。
 */
public class SingletonLazyThree {

    /**
     * 1.将默认构造函数私有化
     */
    private SingletonLazyThree(){}

    /**
     * 2.创建枚举类  避免反射攻击
     */
    private enum SingletonLazy{
        INSTANCE;
        private SingletonLazyThree singleton;

        /**
         * JVM会保证此方法绝对只调用一次
         */
        SingletonLazy(){
            singleton = new SingletonLazyThree();
        }
        public SingletonLazyThree getInstance(){
            return singleton;
        }
    }

    /**
     * .提供外部使用，当需要获得该类的实例
     * @return
     */
    public static SingletonLazyThree getInstance(){
        return SingletonLazy.INSTANCE.getInstance();
    }
}
