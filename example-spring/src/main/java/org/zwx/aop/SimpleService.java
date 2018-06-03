package org.zwx.aop;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import org.zwx.aop.LOG;
import org.zwx.service.impl.SimplePrivilegeServiceImpl;

@Service
public class SimpleService {

    public void doSth() {
        System.out.println("do sth!!!");
    }

    public void doSthWithArg(String s) {
        System.out.println(s);
    }

    @LOG(privilegeService = SimplePrivilegeServiceImpl.class)
    public void aopLOG() {
        System.out.println("write log");
    }

    @OrderAdvice
    public void aopOrder(){
        System.out.println("this is method test advice order!!!");
    }
}
