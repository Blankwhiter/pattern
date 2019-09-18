package com.example.pattern.adapter;

/**
 * 二口转三角适配器 通过继承的方式实现适配器
 */
public class TwoPlugIfAdapterExtands extends TwoPlugIf implements ThreePlugIf{
    @Override
    public void supplyPowerForThree() {
        this.supplyPower();
    }
}
