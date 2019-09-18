package com.example.principle.srp;

/**
 * 错误示范：采购人员接口 将购买电脑 以及 安装系统都两个职责都放在了一起，不利于后面分工。
 *         如果说后期公司又招了运维人员专门管电脑安装 维修等工作，不容易拆分该接口
 */
public interface IPurchaseError {

    /**
     * 购买
     */
      void buyComputer();

    /**
     * 安装
     */
    void setupComputer();
}
