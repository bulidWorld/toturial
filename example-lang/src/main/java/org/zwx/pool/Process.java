package org.zwx.pool;

import java.util.concurrent.TimeUnit;

public class Process {

    public void init() {
        try {
            TimeUnit.SECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void process() {
        //do process
    }
}
