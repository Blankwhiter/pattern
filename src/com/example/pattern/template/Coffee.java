package com.example.pattern.template;

/**
 *  咖啡
 */
public class Coffee extends RefrechBeverageTemplate{
    @Override
    public void brew() {
        System.out.println(" [  泡制咖啡 ]  ");
    }

    @Override
    public void addCondiments() {
        System.out.println(" [  加入糖和饮料 ]  ");
    }
}
