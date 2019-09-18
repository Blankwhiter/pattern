package com.example.pattern.cor;

/**
 * CEO 可以批准70%的折扣
 */
public class CEO extends PriceHandler {
    @Override
    public void processDiscount(float discount) {
        if(discount<=0.7){
            System.out.format("%s 打折了：%.2f%n",this.getClass().getName(),discount);
        }else {
            System.out.println("没得商量了， "+discount+" 的折扣是不能接受的");
        }
    }
}
