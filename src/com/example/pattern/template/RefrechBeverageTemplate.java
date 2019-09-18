package com.example.pattern.template;

/**
 *   模板 将共有的特点 进行私有化，用户只考虑自己独特的业务
 */
public abstract class RefrechBeverageTemplate {

    /**
     * 将水煮沸
     */
    private void boilWater(){
        System.out.println(" ***** 将水煮沸 ***** ");
    }

    /**
     * 制作饮料 由子类实现
     */
    public abstract void brew();

    /**
     * 倒入杯中
     */
    private void pourInCup(){
        System.out.println("***** 倒入杯中 *****");
    }

    /**
     * 加入调料 由子类实现
     */
    public abstract void addCondiments();

    /**
     * 模板步骤 不可被子类重写
     */
    public final void prepareTemplate(){
        boilWater();
        brew();
        pourInCup();
        if (isAddCondiments()) {
            addCondiments();
        }

    }

    /**
     * hook 钩子函数，提供一个默认或空的实现，具体的子类可以自行决定是否挂钩以及如何挂钩
     * 询问是否加入调料
     * @return
     */
    protected boolean isAddCondiments() {
        return true;
    }

}
