package com.example.pattern.proxy;

/**
 *  继承方式实现静态代理
 */
public class Car1 extends Car {
    @Override
    public void move() {
        long startTime = System.currentTimeMillis();
        super.move();
        long endTime = System.currentTimeMillis();
        System.out.println("car1----it cost time : "+(endTime-startTime));
    }
}
