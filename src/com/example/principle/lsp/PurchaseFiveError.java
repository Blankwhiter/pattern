package com.example.principle.lsp;

import com.example.principle.lkp.PurchaseFour;

/**
 * PurchaseFive 是新人，刚进公司，而且总管希望能PurchaseFive能胜任PurchaseFour的工作，
 * 让PurchaseFive成为PurchaseFour的徒弟
 * 但是PurchaseFive 在联系店家的时候，竟然去做了趟附近实体店
 */
public class PurchaseFiveError extends PurchaseFour {
    @Override
    public void contactShop() {
        System.out.println("去了趟附近的实体店");
        super.contactShop();
    }
}
