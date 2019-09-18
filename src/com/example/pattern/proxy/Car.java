package com.example.pattern.proxy;

import java.util.Random;

/**
 *  汽车类
 */
public class Car implements Moveable {
    @Override
    public void move() {
        try {
            Thread.sleep(new Random().nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
