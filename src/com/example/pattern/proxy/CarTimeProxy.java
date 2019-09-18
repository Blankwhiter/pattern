package com.example.pattern.proxy;

/**
 *  业务：时间记录
 */
public class CarTimeProxy implements Moveable{
    private Moveable moveable;

    public CarTimeProxy(Moveable moveable) {
        this.moveable = moveable;
    }

    @Override
    public void move() {
        long startTime = System.currentTimeMillis();
        moveable.move();
        long endTime = System.currentTimeMillis();
        System.out.println("time---it cost time : "+(endTime-startTime));
    }
}
