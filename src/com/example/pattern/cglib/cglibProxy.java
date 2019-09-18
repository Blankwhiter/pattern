package com.example.pattern.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * cglib代理类
 */
public class cglibProxy implements MethodInterceptor{

    private Enhancer enhancer =new Enhancer();

    /**
     * 获得代理
     * @param clazz
     * @return
     */
    public Object getProxy(Class clazz){
        //设置创建子类的类
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);

        return enhancer.create();
    }

    /**
     * 拦截所有目标类的方法调用
     * @param o 目标类的实例
     * @param method  目标方法的反射对象
     * @param objects 方法的参数
     * @param methodProxy 代理类的实例
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        //  代理类使用父类的方法
        methodProxy.invokeSuper(o,objects);
        return null;
    }
}
