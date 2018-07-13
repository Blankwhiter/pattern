package com.example.pattern;

/**
 * 测试类
 */
public class Test {
    public static void main(String[] args) {
        TestSingleton();
    }

    /**
     * 区别：饿汉模式 加载类的时候速度较慢，但运行时获取对象速度较快 线程安全
     *      懒汉模式 加载类的时候速度较快，但运行时获得对象速度较慢  线程不安全
     */
    public static void TestSingleton() {
        //饿汉模式
        SingletonHunger hunger1 = SingletonHunger.getInstance();
        SingletonHunger hunger2 = SingletonHunger.getInstance();
        if (hunger1==hunger2) {
            System.out.println("[**** 饿汉模式 两个实例相等 ****]");
        }else {
            System.out.println("[**** 饿汉模式 两个实例不相等 ****]");
        }
        //懒汉模式
        SingletonLazy lazy1 = SingletonLazy.getInstance();
        SingletonLazy lazy2 = SingletonLazy.getInstance();
        if (lazy1==lazy2) {
            System.out.println("[**** 懒汉模式 两个实例相等 ****]");
        }else {
            System.out.println("[**** 懒汉模式 两个实例不相等 ****]");
        }
    }
}
