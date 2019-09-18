package com.example.pattern.strategy;

/**
 * 奔驰tax 具备水上行驰的能力
 */
public class BcTax extends Tax {
    public BcTax() {
        super.setWaterStrategy(new InWaterAbility());
    }

    @Override
    public void display() {
        System.out.println(" 我是奔驰牌的 ");
    }
}
