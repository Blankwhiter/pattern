package com.example.pattern.builder;

/**
 * 导演者
 */
public class BuilderDirector {
    /**
     * 抽象建造者
     */
    private Builder builder;

    public Builder getBuilder() {
        return builder;
    }

    public void setBuilder(Builder builder) {
        this.builder = builder;
    }

    /**
     * 返回方便面
     * @return
     */
    public InstantNoodles getInstantNoodles(){
        builder.buildSeasoningPacket();
        builder.buildNoodles();
        builder.buildFork();
        return builder.getInstantNoodles();
    }
}
