package org.zwx.delegate.shap_1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClubbedTroll implements Troll {

    private static final Logger LOG = LoggerFactory.getLogger(ClubbedTroll.class);

    private Troll decorated;

    public ClubbedTroll(Troll decorated) {
        this.decorated = decorated;
    }

    public void attack() {
        decorated.attack();
        LOG.info("The troll swings you with a club!");
    }

    public int getAttackPower() {
        return decorated.getAttackPower() + 10;
    }


    public void fleeBattle() {
        decorated.fleeBattle();
    }
}
