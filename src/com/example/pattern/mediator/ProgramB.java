package com.example.pattern.mediator;


/**
 * 程序B
 */
public class ProgramB extends Program {
    @Override
    public void seizeRecourse(int recourse,Mediator mediator) {
        this.recourse = recourse;
        mediator.seizeRecourseForB(recourse);
    }
}
