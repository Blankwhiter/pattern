package com.example.pattern.mediator;

/**
 * 中介者实现
 */
public class ConcreteMediator extends Mediator {

    public ConcreteMediator(Program programA, Program programB) {
        super(programA, programB);
    }

    @Override
    protected void seizeRecourseForA(int recourse) {
        programB.setRecourse(this.resource-recourse);
    }

    @Override
    protected void seizeRecourseForB(int recourse) {
        programA.setRecourse(this.resource-recourse);
    }
}
