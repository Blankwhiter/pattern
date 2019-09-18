package com.example.pattern.strategy;

/**
 *  不能在水上行驰
 */
public class NoWaterAbility  implements WaterStrategy{
    @Override
    public void driveInWater() {
        System.out.println("-------- 我不能在水中行驰 ---------");
    }
}
