package com.example.pattern.singleton;

import java.util.HashMap;
import java.util.Map;

/**
 * 多例模式   类似Spring里面的方法，将类名注册，下次从里面直接获取。
 */
public class MultiSingleton {
    private static Map<String, MultiSingleton> map = new HashMap<String, MultiSingleton>();

    /**
     * 静态代码块 初始化一次
     */
    static {
        MultiSingleton single = new MultiSingleton();
        map.put(single.getClass().getName(), single);
    }

    /**
     * 保护的默认构造子
     */
    protected MultiSingleton() {
    }

    /**
     * 静态工厂方法,返还此类惟一的实例
     * @param name
     * @return
     */
    public static MultiSingleton getInstance(String name) {
        if (name == null) {
            name = MultiSingleton.class.getName();
        }
        if (map.get(name) == null) {
            try {
                map.put(name, (MultiSingleton) Class.forName(name).newInstance());
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return map.get(name);
    }
}
