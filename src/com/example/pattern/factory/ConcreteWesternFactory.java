package com.example.pattern.factory;

/**
 * 西餐厅实现
 */
public class ConcreteWesternFactory implements WesternFactory {
    @Override
    public Dessert produceDessert() {
        return new MiniCake();
    }

    @Override
    public Drink produceDrink() {
        return new MilkTea();
    }
}
