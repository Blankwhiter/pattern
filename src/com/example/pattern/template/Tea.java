package com.example.pattern.template;

/**
 * 茶
 */
public class Tea extends RefrechBeverageTemplate {
    @Override
    public void brew() {
        System.out.println(" [   泡制茶叶   ] ");
    }

    @Override
    public void addCondiments() {
        System.out.println(" [   加入生姜   ] ");
    }
}
