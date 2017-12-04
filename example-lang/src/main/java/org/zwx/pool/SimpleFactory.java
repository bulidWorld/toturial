package org.zwx.pool;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

public class SimpleFactory extends BasePooledObjectFactory<Process>{

    @Override
    public Process create() throws Exception {
        Process process = new Process();
        process.init();
        return process;
    }

    @Override
    public PooledObject<Process> wrap(Process process) {
        return new DefaultPooledObject(process);
    }
}
