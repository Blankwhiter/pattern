package com.example.pattern.strategy;

/**
 *  能在水上行驰
 */
public class InWaterAbility implements WaterStrategy{
    @Override
    public void driveInWater() {
        System.out.println("***** 我能在水中行驰 *****");
    }
}
