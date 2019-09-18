package com.example.principle.crp;

/**
 * 电脑 搭载这linux系统
 */
public class DellComputerFourError extends Linux {
    public void power(){
        System.out.println("按下电源键");
        super.run();
    }
}
