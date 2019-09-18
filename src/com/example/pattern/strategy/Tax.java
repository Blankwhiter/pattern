package com.example.pattern.strategy;

/**
 * 出租
 */
public abstract class Tax {
    /**
     * 通用行为 由超类实现
     */
    public void drive(){
        System.out.println(" 可以驾驶 ");
    }

    /**
     * 出租的品牌各有不同，声明abstract  由子类实现
     */
    public abstract void display();

    private WaterStrategy waterStrategy;

    public void setWaterStrategy(WaterStrategy waterStrategy) {
        this.waterStrategy = waterStrategy;
    }
    public void showWaterAbility(){
        waterStrategy.driveInWater();
    }
}
