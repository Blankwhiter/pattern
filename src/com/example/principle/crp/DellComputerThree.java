package com.example.principle.crp;

/**
 * 合成复用示例 戴尔电脑
 */
public class DellComputerThree {

    private OperationSystem operationSystem;

    public void setOperationSystem(OperationSystem operationSystem) {
        this.operationSystem = operationSystem;
    }
    public  void power(){
        System.out.println("按下电源键");
        operationSystem.run();
    }
}
