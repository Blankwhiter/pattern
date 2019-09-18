package com.example.pattern.cor;

/**
 * 副主席 可以批准60%的折扣
 */
public class VicePresident extends PriceHandler {
    @Override
    public void processDiscount(float discount) {
        if(discount<=0.6){
            System.out.format("%s 打折了：%.2f%n",this.getClass().getName(),discount);
        }else {
            successor.processDiscount(discount);
        }
    }
}
