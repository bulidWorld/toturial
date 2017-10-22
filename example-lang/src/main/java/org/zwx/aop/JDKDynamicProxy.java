package org.zwx.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKDynamicProxy<T> implements InvocationHandler {

    T t;

    public JDKDynamicProxy(T t)
    {
        this.t = t;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        before();
        Object result = method.invoke(args);
        after();
        return result;
    }

    private void before() {
        System.out.println("before method....");
    }

    private void after() {
        System.out.println("after method.....");
    }


    public <T> T getProxyInstance() {
        Class cls = t.getClass();
        return (T)Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), this);
    }

}
