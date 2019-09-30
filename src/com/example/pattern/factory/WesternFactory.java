package com.example.pattern.factory;

/**
 * 西餐厅工厂接口
 */
public interface WesternFactory {
    /**
     * 制作甜点
     * @return
     */
    Dessert produceDessert();

    /**
     * 制作饮料
     * @return
     */
    Drink produceDrink();
}
