package org.zwx.delegate.simple.printer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zwx.delegate.simple.Printer;

public class CanonPrinter implements Printer {

    private static final Logger LOG = LoggerFactory.getLogger(CanonPrinter.class);

    @Override
    public void print(String msg) {
        LOG.info("Canon:{}",msg);
    }
}
