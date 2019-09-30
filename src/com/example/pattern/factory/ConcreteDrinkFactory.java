package com.example.pattern.factory;

/**
 * 饮料工厂实现
 */
public class ConcreteDrinkFactory implements DrinkFactory {
    @Override
    public Drink produceDrink() {
        return new MilkTea();
    }
}
