package org.zwx.delegate.simple.printer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zwx.delegate.simple.Printer;

public class EsponPrinter implements Printer {

    private static final Logger LOG = LoggerFactory.getLogger(EsponPrinter.class);

    @Override
    public void print(String msg) {
        LOG.info("Espon:{}",msg);
    }
}
