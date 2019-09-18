package com.example.pattern.cor;

/**
 *  责任
 */
public abstract class PriceHandler{
    /**
     * 直接后继 用于传递请求
     */
    protected PriceHandler successor;

    public void setSuccessor(PriceHandler successor) {
        this.successor = successor;
    }

    /**
     * 处理折扣
     * @param discount
     */
    public abstract void processDiscount(float discount);

}
