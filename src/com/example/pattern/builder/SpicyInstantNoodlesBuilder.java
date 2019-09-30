package com.example.pattern.builder;

/**
 * 麻辣方便面
 */
public class SpicyInstantNoodlesBuilder implements Builder{

    private InstantNoodles instantNoodles = new InstantNoodles();

    @Override
    public void buildSeasoningPacket() {
        instantNoodles.setSeasoningPacket("麻辣调味包");
    }

    @Override
    public void buildNoodles() {
        instantNoodles.setNoodles("大块面");
    }

    @Override
    public void buildFork() {
        instantNoodles.setFork("塑料叉");
    }

    @Override
    public InstantNoodles getInstantNoodles() {
        return instantNoodles;
    }
}
