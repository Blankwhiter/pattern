package com.example.principle.crp;

/**
 * 电脑 搭载这windows系统
 */
public class DellComputerThreeError extends Windows {
    public void power(){
        System.out.println("按下电源键");
        super.run();
    }
}
