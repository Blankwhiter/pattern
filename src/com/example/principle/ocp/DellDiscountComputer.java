package com.example.principle.ocp;

/**
 * 当遇到节假日 促进促销，对电脑进行打折
 */
public class DellDiscountComputer extends DellComputer {
    /**
     * 构造方法 进行设值
     *
     * @param id
     * @param name
     * @param price
     */
    public DellDiscountComputer(Integer id, String name, Double price) {
        super(id, name, price);
    }

    /**
     * 对原来的类进行扩展，不改变原来的接口
     * @return
     */
    public Double getDiscountPrice(){
        return super.getPrice()*0.9;
    }
}
