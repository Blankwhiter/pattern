package com.example.principle.ocp;

/**
 * 戴尔电脑
 */
public class DellComputer implements IComputer {

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
    public  DellComputer(Integer id,String name,Double price){
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
}
