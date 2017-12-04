package org.zwx.delegate.shap_1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleTroll implements Troll{

    private static final Logger LOG = LoggerFactory.getLogger(SimpleTroll.class);

    public void attack() {
        LOG.info("the troll tries to grab you!");
    }

    public int getAttackPower() {
        return 10;
    }

    public void fleeBattle() {
        LOG.info("the troll shrink in horror and run away!");
    }
}
