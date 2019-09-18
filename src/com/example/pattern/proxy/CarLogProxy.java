package com.example.pattern.proxy;

/**
 * 业务：日志业务
 */
public class CarLogProxy implements Moveable{
    private Moveable moveable;

    public CarLogProxy(Moveable moveable) {
        this.moveable = moveable;
    }

    @Override
    public void move() {
        moveable.move();
        System.out.println("log---run---ok");
    }
}
