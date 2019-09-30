package com.example.pattern.factory;

/**
 * 小蛋糕
 */
public class MiniCake implements Dessert {
    @Override
    public void withFlour() {
        System.out.println("小麦蛋糕甜点");
    }
}
