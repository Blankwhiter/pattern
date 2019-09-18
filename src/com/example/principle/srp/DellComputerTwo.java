package com.example.principle.srp;


/**
 * 戴尔电脑
 */
public class DellComputerTwo implements IComputerTwo {

    /**
     * id
     */
    private Integer id;
    /**
     *  名称
     */
    private String name;
    /**
     *  操作系统
     */
    private String system;
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
    public DellComputerTwo(Integer id, String name, String system, Double price){
        this.id = id;
        this.name = name;
        this.system = system;
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
    public String getSystem() {
        return system;
    }
}
