package com.example.principle.lkp;


/**
 * 错误示范：某一天 采购部长想知道对接的店家那里还有多少的电脑存量。这时候自己去询问店家
 */
public class ManagerError {

    /**
     * 直接询问店家剩余数量
     * @param shop
     */
    public void inquiryRest(Shop shop){
        shop.rest();
    }
}
