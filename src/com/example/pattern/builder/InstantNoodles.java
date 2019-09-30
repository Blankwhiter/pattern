package com.example.pattern.builder;

/**
 * 方便面
 */
public class InstantNoodles {
    /**
     * 调味包
     */
    private String seasoningPacket;

    /**
     * 面块
     */
    private String noodles;

    /**
     * 叉子
     */
    private String fork;

    public String getSeasoningPacket() {
        return seasoningPacket;
    }

    public void setSeasoningPacket(String seasoningPacket) {
        this.seasoningPacket = seasoningPacket;
    }

    public String getNoodles() {
        return noodles;
    }

    public void setNoodles(String noodles) {
        this.noodles = noodles;
    }

    public String getFork() {
        return fork;
    }

    public void setFork(String fork) {
        this.fork = fork;
    }
}
