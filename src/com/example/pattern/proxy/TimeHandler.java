package com.example.pattern.proxy;



import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 时间 InvocationHandler
 */
public class TimeHandler implements InvocationHandler{
    private Object target;

    public TimeHandler(Object target) {
        this.target = target;
    }

    /**
     *
     * @param proxy 被代理对象
     * @param method 被代理对象的方法
     * @param args 方法的参数
     * @return object 方法的返回值
     * @throws Throwable
     */
    @Override
    public java.lang.Object invoke(java.lang.Object proxy, Method method, java.lang.Object[] args) throws Throwable {
        long startTime = System.currentTimeMillis();
        method.invoke(target);
        long endTime = System.currentTimeMillis();
        System.out.println("InvocationHandler----it cost time : "+(endTime-startTime));
        return null;
    }
}
