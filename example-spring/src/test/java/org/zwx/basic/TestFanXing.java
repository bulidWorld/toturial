package org.zwx.basic;

public class TestFanXing {

    public <T> void test(T t){
        t = returnT(t);
    }

    public <T> T returnT(T t){
        return t;
    }
}
