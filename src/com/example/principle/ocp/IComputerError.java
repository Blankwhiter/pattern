package com.example.principle.ocp;
/**
 * 错误示范：电脑接口 由于需求变动 现在需要遇到节假日进行打折促销活动.接口应该是稳定的，不应该是经常修改的。
 */
public interface IComputerError {
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

    /**
     * 获得打折价格
     * @return
     */
    Double getDiscountPrice();
}
