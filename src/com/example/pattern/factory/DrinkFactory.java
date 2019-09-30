package com.example.pattern.factory;

/**
 * 饮料工厂
 */
public interface DrinkFactory {
    /**
     * 制作饮料
     * @return
     */
    Drink produceDrink();
}
