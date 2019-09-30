package com.example.pattern.mediator;

/**
 * 程序接口
 */
public abstract class Program {

    /**
     * 程序所占用的资源
     */
    protected int recourse;
    /**
     * 通过中介者 影响另外一个程序占用资源
     * @param recourse
     */
    public abstract  void seizeRecourse(int recourse,Mediator mediator);




    public void setRecourse(int recourse) {
        this.recourse = recourse;
    }

    /**
     * 获得当前占用资源情况
     */
    public int getRecourse() {
        return recourse;
    }
}
