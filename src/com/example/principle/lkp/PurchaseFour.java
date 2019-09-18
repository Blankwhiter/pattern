package com.example.principle.lkp;

import com.example.principle.isp.IPurchaseThree;
import com.example.principle.srp.IComputerTwo;

/**
 * 采购人员对接店家 询问剩余电脑数量
 */
public class PurchaseFour implements IPurchaseThree {

    private IComputerTwo computer;
    //这里的shop也应该面对接口编程，而不是具体实例，但此例只为演示迪米特法则
    private Shop shop;

    public void setShop(Shop shop) {
        this.shop = shop;
    }

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

    //模拟店家回答
    public void inquiryRest(){
        shop.rest();
    }

}
