package com.example.pattern.factory;

/**
 * 奶茶
 */
public class MilkTea implements Drink{
    @Override
    public void withMaterial() {
        System.out.println("混合珍珠奶茶");
    }
}
