package org.zwx.business.delegate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JmsService implements BusinessService {
    private static final Logger LOG = LoggerFactory.getLogger(EjbService.class);

    @Override
    public void doProcess() {
        LOG.info("jms service");
    }
}
