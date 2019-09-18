package com.example.principle.ocp;

/**
 * 电脑接口
 */
public interface IComputer {
    /**
     * 获得id
     * @return
     */
    Integer getId();

    /**
     * 获得名称
     * @return
     */
    String getName();

    /**
     * 获得价格
     * @return
     */
    Double getPrice();
}
