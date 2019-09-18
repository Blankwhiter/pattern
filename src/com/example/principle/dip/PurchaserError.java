package com.example.principle.dip;

import com.example.principle.ocp.DellComputer;

/**
 * 错误示范：采购人员想咨询每个电脑原始价钱 都是依赖具体的方法
 */
public class PurchaserError {

    /**
     * 询问戴尔电脑的价格
     * @param dellComputer
     * @return
     */
    public Double inquiryDellComputerPrice(DellComputer dellComputer){
        return dellComputer.getPrice();
    }

    /**
     * 获得联想电脑的价格
     * @param lenovoComputer
     * @return
     */
    public Double inquiryLenovoComputerPrice(LenovoComputer lenovoComputer){
        return lenovoComputer.getPrice();
    }
}
