package com.example.pattern.cor;

/**
 * 价格 工厂
 */
public class PriceHandlerFactory {
    public static PriceHandler createHandler() {
        PriceHandler sales = new Sales();
        PriceHandler manager = new Manager();
        PriceHandler direct = new Director();
        PriceHandler vicePresident = new VicePresident();
        PriceHandler ceo = new CEO();
        sales.setSuccessor(manager);
        manager.setSuccessor(direct);
        direct.setSuccessor(vicePresident);
        vicePresident.setSuccessor(ceo);
        return sales;
    }
}
