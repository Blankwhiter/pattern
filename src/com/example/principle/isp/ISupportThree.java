package com.example.principle.isp;
/**
 * 后勤接口  提供安装系统，连接打印机
 */
public interface ISupportThree {
        /**
         * 安装
         */
        void setupComputer();

        /**
         * 连接打印机
         */
        void linkPrinter();
}
