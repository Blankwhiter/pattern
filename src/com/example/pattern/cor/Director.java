package com.example.pattern.cor;

/**
 *  销售总监 可以批准50%的折扣
 */
public class Director extends PriceHandler {
    @Override
    public void processDiscount(float discount) {
        if(discount<=0.5){
            System.out.format("%s 打折了：%.2f%n",this.getClass().getName(),discount);
        }else {
            successor.processDiscount(discount);
        }
    }
}
