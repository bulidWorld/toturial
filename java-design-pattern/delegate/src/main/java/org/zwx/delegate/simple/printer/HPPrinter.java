package org.zwx.delegate.simple.printer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zwx.delegate.simple.Printer;

public class HPPrinter implements Printer {

    private static final Logger LOG = LoggerFactory.getLogger(HPPrinter.class);

    @Override
    public void print(String msg) {
        LOG.info("HP:{}",msg);
    }
}
