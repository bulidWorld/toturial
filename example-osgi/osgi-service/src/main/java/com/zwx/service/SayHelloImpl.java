package com.zwx.service;

import com.zwx.api.SayHello;

public class SayHelloImpl implements SayHello {
    @Override
    public void sayHello() {
        System.out.println("hello world");
    }
}
