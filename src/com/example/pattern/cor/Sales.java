package com.example.pattern.cor;

/**
 *  销售人员 可以批准5%的折扣
 */
public class Sales extends PriceHandler {
    @Override
    public void processDiscount(float discount) {
        if(discount<=0.05){
            System.out.format("%s 打折了：%.2f%n",this.getClass().getName(),discount);
        }else {
            successor.processDiscount(discount);
        }
    }
}
