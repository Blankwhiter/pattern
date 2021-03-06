package com.example.principle.srp;

/**
 * 采购人员.公司有意再招收后勤人员来指定安装系统等工作。但是人还没来，故现在采购电脑以及安装系统还是都交予采购人员
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
