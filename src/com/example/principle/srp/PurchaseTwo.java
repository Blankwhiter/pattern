package com.example.principle.srp;

/**
 * 采购人员，假设公司 还未明确分工 采购电脑以及安装系统都交予采购人员
 */
public class PurchaseTwo implements IPurchase,ISupport{

    private IComputerTwo computer;

    public void setComputer(IComputerTwo computer) {
        this.computer = computer;
    }

    @Override
    public void buyComputer() {
        System.out.println("购买了"+computer.getName());
    }

    @Override
    public void setupComputer() {
        System.out.println("安装了"+computer.getSystem());
    }
}
