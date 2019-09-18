package com.example.pattern.template;

/**
 *  不加入生姜的茶
 */
public class FreshTea extends RefrechBeverageTemplate{
    @Override
    public void brew() {
        System.out.println(" [   泡制清新茶叶   ] ");
    }

    @Override
    public void addCondiments() {
        System.out.println(" [   加入生姜   ] ");
    }

    @Override
    protected boolean isAddCondiments() {
        return false;
    }
}
