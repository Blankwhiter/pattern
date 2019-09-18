package com.example.pattern.cor;

/**
 *  客户
 */
public class Customer {
    private PriceHandler priceHandler;

    public void setPriceHandler(PriceHandler priceHandler) {
        this.priceHandler = priceHandler;
    }
    public void requestDiscount(float discount){
        priceHandler.processDiscount(discount);
    }
}
