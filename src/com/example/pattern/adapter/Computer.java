package com.example.pattern.adapter;

/**
 *
 */
public class Computer {
    private ThreePlugIf threePlugIf;

    public Computer(ThreePlugIf threePlugIf) {
        this.threePlugIf = threePlugIf;
    }
    public void charge(){
        threePlugIf.supplyPowerForThree();
        System.out.println("  ----*** 电脑充电中 ***----  ");
    }
}
