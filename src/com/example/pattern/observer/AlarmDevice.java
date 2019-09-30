package com.example.pattern.observer;

import java.util.Observable;
import java.util.Observer;

/**
 *  报警装置
 */
public class AlarmDevice implements Observer {

    /**
     * 报警装置名称
     */
    private String name;

    public AlarmDevice(String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }


    /**
     * 通知消息
     * @param o 可观察者
     * @param arg 传递的参数
     */
    @Override
    public void update(Observable o, Object arg) {
        TemperatureSensor temperatureSensor = (TemperatureSensor) o;
        int temp = (int) arg;
        System.out.println("警报通知："+temperatureSensor.getName()+"传感器 达到温度"+temp);

    }
}
