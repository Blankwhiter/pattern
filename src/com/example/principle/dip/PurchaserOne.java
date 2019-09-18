package com.example.principle.dip;

import com.example.principle.ocp.IComputer;

/**
 * 采购人员
 */
public class PurchaserOne {


    private IComputer computer;


    /**
     * 使用setter，而不是构造方法 ，避免每次都要创建一个对象
     * @param computer
     */
    public void setComputer(IComputer computer) {
        this.computer = computer;
    }

    public Double inquiryComputerPrice(){
        return computer.getPrice();
    }
}
