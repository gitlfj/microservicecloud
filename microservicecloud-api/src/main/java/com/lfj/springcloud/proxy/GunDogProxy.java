package com.lfj.springcloud.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *  代理对象
 */
public class GunDogProxy {

    // 要代理的对象
    private Object target;

    public GunDogProxy(Object target) {
        this.target = target;
    }

    public Object gunDogProxyMethod() {
        Object proxy;

        //代理对象由哪个类加载器负责加载
        ClassLoader classLoader = target.getClass().getClassLoader();

        // 代理对象的类型，其中有哪些方法？
        Class<?>[] interfaces = target.getClass().getInterfaces();

        //当调用代理对象其中的方法的时候，执行该代码
        InvocationHandler invocationHandler = (Object proxy1, Method method, Object[] args1) -> {
            DogUtils.method1();
            method.invoke(target, args1);
            DogUtils.method2();
            return proxy1;
        };

        proxy = Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);

        return proxy;
    }

}
