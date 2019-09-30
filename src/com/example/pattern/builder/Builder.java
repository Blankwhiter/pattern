package com.example.pattern.builder;

/**
 * 方便面制造接口
 */
public interface Builder {

    /**
     * 制造调味包
     */
    void buildSeasoningPacket();

    /**
     * 制造面块
     */
    void buildNoodles();

    /**
     * 制造叉子
     */
    void buildFork();

    /**
     * 获得方便面
     * @return
     */
    InstantNoodles getInstantNoodles();
}
