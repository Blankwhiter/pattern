package com.example.pattern.observer;

import java.util.Observable;

/**
 * 温度传感器
 */
public class TemperatureSensor extends Observable {

    /**
     * 传感器名称
     */
    private String name;

    /**
     * 传感器温度值
     */
    private int temperature;

    /**
     * 传感器阈值
     */
    private int threshold;

    public TemperatureSensor(String name, int threshold){
        this.name =name;
        this.threshold = threshold;
    }

    public String getName() {
        return name;
    }

    /**
     * 温度攀升
     * @param temperature
     */
    public void rise(int temperature){
        this.temperature = temperature;
        System.out.println("温度攀升至："+this.temperature+"C");
        if(temperature>= threshold){
            //改变状态
            setChanged();
            //通知观察者
            notifyObservers(temperature);
        }

    }

}
