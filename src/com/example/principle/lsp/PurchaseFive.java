package com.example.principle.lsp;

import com.example.principle.lkp.PurchaseFour;

/**
 * PurchaseFive 是新人，刚进公司，而且总管希望能PurchaseFive能胜任PurchaseFour的工作，
 * 让PurchaseFive成为PurchaseFour的徒弟
 */
public class PurchaseFive extends PurchaseFour {

    /**
     * 外出
     */
    public void goOutside(){
        System.out.println("去了趟附近的实体店");
    }
}
