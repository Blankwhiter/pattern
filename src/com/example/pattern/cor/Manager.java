package com.example.pattern.cor;

/**
 *   销售经理 可以批准30%的折扣
 */
public class Manager extends PriceHandler {
    @Override
    public void processDiscount(float discount) {
        if(discount<=0.3){
            System.out.format("%s 打折了：%.2f%n",this.getClass().getName(),discount);
        }else {
            successor.processDiscount(discount);
        }
    }
}
