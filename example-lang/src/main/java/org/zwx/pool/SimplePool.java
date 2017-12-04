package org.zwx.pool;

import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

public class SimplePool {

    GenericObjectPool<Process> pool = null;

    private static final SimplePool INSTANCE = new SimplePool();


    private SimplePool() {
        init();
    }

    public static SimplePool getInstance() {
        return INSTANCE;
    }

    public Process getObject() throws Exception {
       return pool.borrowObject();
    }

    public void retunObject(Process process) {
        pool.returnObject(process);
    }



    private void init() {

        SimpleFactory simpleFactory = new SimpleFactory();
        GenericObjectPoolConfig config = new GenericObjectPoolConfig();

        config.setMaxTotal(150);
        config.setMaxWaitMillis(10 * 1000);
        config.setBlockWhenExhausted(true);
        config.setMaxIdle(150);
        config.setMinIdle(0);

        pool = new GenericObjectPool<Process>(simpleFactory, config);
    }
}
