package com.example.principle.isp;

import com.example.principle.srp.IComputerTwo;

/**
 * 错误示范： 采购人员，假设公司 还未明确分工 采购电脑以及安装系统都交予采购人员
 */
public class PurchaseThreeError implements IPurchaseThreeError{

    private IComputerTwo computer;

    public void setComputer(IComputerTwo computer) {
        this.computer = computer;
    }
    @Override
    public void buyComputer() {
        System.out.println("购买了"+computer.getName());
    }

    @Override
    public void printInvoice() {
        System.out.println("打印了"+computer.getName()+"的发票");
    }

    @Override
    public void contactShop() {
        System.out.println("联系了"+computer.getName()+"的店家");
    }

    @Override
    public void setupComputer() {
        System.out.println("安装了"+computer.getSystem());
    }

    @Override
    public void linkPrinter() {
        System.out.println("连上了公司的打印机");
    }
}
