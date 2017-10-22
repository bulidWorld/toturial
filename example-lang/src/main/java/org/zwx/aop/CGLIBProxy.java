package org.zwx.aop;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CGLIBProxy implements MethodInterceptor {

    private static final CGLIBProxy INSTANCE = new CGLIBProxy();

    private CGLIBProxy() {

    }

    public CGLIBProxy getInstance() {
        return INSTANCE;
    }


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        before();
        Object result = methodProxy.invokeSuper(o, objects);
        after();
        return result;
    }


    public <T> T getProxy(Class<T> cls) {
        return (T) Enhancer.create(cls, this);
    }

    private void before() {
        System.out.println("before method....");
    }

    private void after() {
        System.out.println("after method...");
    }
}
