package org.zwx.service;

import org.springframework.stereotype.Service;
import org.zwx.aop.LOG;

@Service
public class SimpleService {

    public void doSth() {
        System.out.println("do sth!!!");
    }

    @LOG
    public void aopLOG() {
        System.out.println("write log");
    }
}
