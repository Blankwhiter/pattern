package com.example.pattern.mediator;

/**
 * 抽象中介者
 */
public abstract class Mediator {
    /**
     * 总共100份的资源数量
     */
    protected int resource = 100;
    /**
     * 程序A
     */
    protected Program programA;
    /**
     * 程序B
     */
    protected Program programB;

    /**
     * 通过构造方法传入A，B两个程序
     * @param programA
     * @param programB
     */
    public Mediator(Program programA,Program programB){
        this.programA = programA;
        this.programB = programB;
    }

    /**
     * A主动抢占资源
     * @param recourse
     */
    protected abstract void seizeRecourseForA(int recourse);

    /**
     * B主动抢占资源
     * @param recourse
     */
    protected abstract void seizeRecourseForB(int recourse);


}
