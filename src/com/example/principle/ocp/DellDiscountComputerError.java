package com.example.principle.ocp;

/**
 * 错误示范：在原来接口直接进行修改，加入getDiscountPrice方法
 */
public class DellDiscountComputerError  implements IComputerError  {
    /**
     * id
     */
    private Integer id;
    /**
     *  名称
     */
    private String name;
    /**
     * 价格
     */
    private Double price;

    /**
     * 构造方法 进行设值
     * @param id
     * @param name
     * @param price
     */
    public  DellDiscountComputerError(Integer id,String name,Double price){
        this.id = id;
        this.name = name;
        this.price = price;
    }
    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Double getPrice() {
        return price;
    }

    @Override
    public Double getDiscountPrice() {
        return price*0.9;
    }
}
