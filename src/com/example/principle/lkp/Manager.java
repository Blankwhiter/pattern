package com.example.principle.lkp;


/**
 * 某一天 采购部长想知道对接的店家那里还有多少的电脑存量。这时候就需要通过采购人员去询问，而不是自己去询问店家
 */
public class Manager {

    /**
     * 通过采购人员询问剩余数量
     * @param purchaseFour
     */
    public void inquiryRest(PurchaseFour purchaseFour){
        purchaseFour.inquiryRest();
    }
}
