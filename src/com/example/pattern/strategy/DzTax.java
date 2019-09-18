package com.example.pattern.strategy;

/**
 *  大众tax 不具备水上行驰
 */
public class DzTax extends Tax {
    public DzTax() {
        super.setWaterStrategy(new NoWaterAbility());
    }

    @Override
    public void display() {
        System.out.println(" 我是大众牌的 ");
    }
}
