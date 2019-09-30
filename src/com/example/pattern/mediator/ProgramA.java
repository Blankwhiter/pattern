package com.example.pattern.mediator;

/**
 * 程序A
 */
public class ProgramA extends Program {
    @Override
    public void seizeRecourse(int recourse,Mediator mediator) {
        this.recourse = recourse;
        mediator.seizeRecourseForA(recourse);
    }
}
