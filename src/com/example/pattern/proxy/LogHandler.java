package com.example.pattern.proxy;



import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 日志 InvocationHandler
 */
public class LogHandler implements InvocationHandler{
    private Object target;

    public LogHandler(Object target) {
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
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        method.invoke(target);
        System.out.println("InvocationHandler---log run ok ");
        return null;
    }
}
