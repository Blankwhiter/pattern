package com.example.pattern.builder;

/**
 * 海鲜方便面
 */
public class SeafoodInstantNoodlesBuilder implements Builder{

    private InstantNoodles instantNoodles =new InstantNoodles();

    @Override
    public void buildSeasoningPacket() {
        instantNoodles.setSeasoningPacket("海鲜调味包");
    }

    @Override
    public void buildNoodles() {
        instantNoodles.setNoodles("小块面");
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
