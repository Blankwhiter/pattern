package com.example.pattern.adapter;

/**
 *  二口转三角适配器 通过组合的方式实现适配器
 */
public class TwoPlugIfAdapter implements ThreePlugIf {
    private TwoPlugIf twoPlugIf;

    public TwoPlugIfAdapter(TwoPlugIf twoPlugIf) {
        this.twoPlugIf = twoPlugIf;
    }

    @Override
    public void supplyPowerForThree() {
        System.out.println("[    进入到适配器中    ]");
        twoPlugIf.supplyPower();
        System.out.println("[    ************    ]");
    }
}
