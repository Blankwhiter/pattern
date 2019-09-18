package com.example.principle;

import com.example.principle.crp.*;
import com.example.principle.dip.LenovoComputer;
import com.example.principle.dip.PurchaserOne;
import com.example.principle.dip.PurchaserError;
import com.example.principle.isp.PurchaseThree;
import com.example.principle.isp.PurchaseThreeError;
import com.example.principle.lkp.Manager;
import com.example.principle.lkp.ManagerError;
import com.example.principle.lkp.PurchaseFour;
import com.example.principle.lkp.Shop;
import com.example.principle.lsp.PurchaseFive;
import com.example.principle.lsp.PurchaseFiveError;
import com.example.principle.ocp.DellComputer;
import com.example.principle.ocp.DellDiscountComputer;
import com.example.principle.ocp.DellDiscountComputerError;
import com.example.principle.srp.DellComputerTwo;
import com.example.principle.srp.PurchaseTwo;
import com.example.principle.srp.PurchaseTwoError;

/**
 * 原则测试类
 */
public class PrincipleTest {
    public static void main(String[] args) {
        testOCP();
        testDIP();
        testSRP();
        testISP();
        testLKP();
        testCRP();
    }

    /**
     * 测试开闭原则
     */
    public static void testOCP(){
        //1.原价电脑信息
        DellComputer dellComputer = new DellComputer(1, "戴尔e320", 5000D);
        System.out.println("最初电脑信息 ====  id: "+dellComputer.getId()+"  名称："+dellComputer.getName()
                +"  价格："+dellComputer.getPrice());
        //2.打折后电脑信息 虽然实现了功能，但是违反开闭原则，在原来的接口上直接修改
        DellDiscountComputerError discountComputerError = new DellDiscountComputerError(1, "戴尔e320", 5000D);
        System.out.println("打折电脑信息error  ====  id: "+discountComputerError.getId()+"  名称："+discountComputerError.getName()
                +"  价格："+discountComputerError.getPrice()+"  打折价格："+discountComputerError.getDiscountPrice());


        //3.打折后电脑信息 对原有的类进行扩展,不进行修改现有的接口 符合开闭原则
        DellDiscountComputer dellDiscountComputer = new DellDiscountComputer(1, "戴尔e320", 5000D);
        System.out.println("打折电脑信息 ====  id: "+dellDiscountComputer.getId()+"  名称："+dellDiscountComputer.getName()+"  原价价格："
                +dellDiscountComputer.getPrice()+"  打折价格："+dellDiscountComputer.getDiscountPrice());

    }


    /**
     * 测试依赖倒置原则
     */
    public static void testDIP(){
        DellComputer dellComputer = new DellComputer(1, "戴尔e320", 5000D);
        LenovoComputer lenovoComputer = new LenovoComputer(1, "联想e480", 6000D);
        //直接依赖具体实现
        PurchaserError purchaserError = new PurchaserError();
        System.out.println("采购人员error 咨询：戴尔价钱="+purchaserError.inquiryDellComputerPrice(dellComputer)
                +"联想价钱="+purchaserError.inquiryLenovoComputerPrice(lenovoComputer));
        //面向了接口编程
        PurchaserOne purchaser = new PurchaserOne();
        purchaser.setComputer(dellComputer);
        System.out.println("采购人员 咨询：戴尔价钱="+purchaser.inquiryComputerPrice());
        purchaser.setComputer(lenovoComputer);
        System.out.println("采购人员 咨询：联想价钱="+purchaser.inquiryComputerPrice());
    }

    /**
     * 测试单一职责原则
     */
    public static void testSRP(){
        DellComputerTwo dellComputerTwo = new DellComputerTwo(3, "戴尔e340", "windows 10", 5500D);
        PurchaseTwoError purchaseTwoError = new PurchaseTwoError();
        purchaseTwoError.setComputer(dellComputerTwo);
        purchaseTwoError.buyComputer();
        purchaseTwoError.setupComputer();

        PurchaseTwo purchaseTwo = new PurchaseTwo();
        purchaseTwo.setComputer(dellComputerTwo);
        purchaseTwo.buyComputer();
        purchaseTwo.setupComputer();
    }

    /**
     * 测试接口隔离原则
     */
    public static void testISP(){
        DellComputerTwo dellComputerTwo = new DellComputerTwo(3, "戴尔e340", "windows 10", 5500D);
        PurchaseThreeError purchaseThreeError = new PurchaseThreeError();
        purchaseThreeError.setComputer(dellComputerTwo);
        purchaseThreeError.buyComputer();
        purchaseThreeError.contactShop();
        purchaseThreeError.printInvoice();
        purchaseThreeError.setupComputer();
        purchaseThreeError.linkPrinter();

        PurchaseThree purchaseThree = new PurchaseThree();
        purchaseThree.setComputer(dellComputerTwo);
        purchaseThree.buyComputer();
        purchaseThree.contactShop();
        purchaseThree.printInvoice();
        purchaseThree.setupComputer();
        purchaseThree.linkPrinter();
    }



    /**
     * 测试迪米特法则
     */
    public static void testLKP(){
        DellComputerTwo dellComputerTwo = new DellComputerTwo(3, "戴尔e340", "windows 10", 5500D);
        Shop shop = new Shop();
        //部门管理者 自己询问 违反迪米特法则
        ManagerError managerError = new ManagerError();
        managerError.inquiryRest(shop);

        //部门管理者通过采购人员咨询
        PurchaseFour purchaseFour = new PurchaseFour();
        purchaseFour.setComputer(dellComputerTwo);
        purchaseFour.setShop(shop);
        Manager manager = new Manager();
        manager.inquiryRest(purchaseFour);

    }


    /**
     * 测试里氏替换原则
     */
    public static void testLSP(){
        DellComputerTwo dellComputerTwo = new DellComputerTwo(3, "戴尔e340", "windows 10", 5500D);
        Shop shop = new Shop();
        PurchaseFiveError purchaseFiveError = new PurchaseFiveError();
        purchaseFiveError.setComputer(dellComputerTwo);
        purchaseFiveError.setShop(shop);
        //部门管理者让采购人员联系商家的时候  他竟然还出去调研了。
        purchaseFiveError.contactShop();

        PurchaseFive purchaseFive = new PurchaseFive();
        purchaseFive.setComputer(dellComputerTwo);
        purchaseFive.setShop(shop);
        //部门管理者让采购人员联系商家的时候  他就咨询了店家。
        purchaseFive.contactShop();

    }


    /**
     * 测试合成复用原则
     */
    public static void testCRP(){
        //通过每次直接继承抽象类。每次有新的类型则会有新的类成对产生
        DellComputerThreeError dellComputerThreeError = new DellComputerThreeError();
        dellComputerThreeError.power();

        DellComputerFourError dellComputerFourError = new DellComputerFourError();
        dellComputerFourError.power();

        //通过组合的方式，可以减少
        DellComputerThree dellComputerThree = new DellComputerThree();
        dellComputerThree.setOperationSystem(new Windows());
        dellComputerThree.power();

        dellComputerThree.setOperationSystem(new Linux());
        dellComputerThree.power();
    }
}
