package com.example.pattern.proxy;

/**
 * 聚合（一个类中包含另外一个类） 接口的形式
 */
public class Car2 implements Moveable {

    private Car car;

    public Car2(Car car) {
        super();
        this.car = car;
    }

    @Override
    public void move() {
        long startTime = System.currentTimeMillis();
        car.move();
        long endTime = System.currentTimeMillis();
        System.out.println("car2---it cost time : "+(endTime-startTime));
    }
}
