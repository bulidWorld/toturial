package com.zwx;

import com.zwx.api.SayHello;
import com.zwx.service.SayHelloImpl;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import java.util.ArrayList;
import java.util.List;

public class Activator implements BundleActivator{


    @Override
    public void start(BundleContext context) throws Exception {
        System.out.println("hello client!!!");
        SayHello sayHello = new SayHelloImpl();
        sayHello.sayHello();
        List lst = new ArrayList();

        lst.add(context.getProperty("port"));
        System.out.println(lst);
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        System.out.println("goodbye client");
    }
}
