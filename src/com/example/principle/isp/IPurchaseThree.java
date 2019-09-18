package com.example.principle.isp;

/**
 *  采购人员的职责 包含采购电脑，打印发票，对接店家等职责
 */
public interface IPurchaseThree {
    /**
     * 购买
     */
    void buyComputer();

    /**
     * 打印发票
     */
    void printInvoice();

    /**
     * 对接店家
     */
    void contactShop();

}
