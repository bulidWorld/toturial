package org.zwx.delegate.shap_1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {

    private static final Logger LOG = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        Troll troll = new SimpleTroll();
        troll.attack();
        troll.fleeBattle();
        LOG.info("Simple troll attack:{}", troll.getAttackPower());

        troll = new ClubbedTroll(troll);
        troll.attack();
        troll.fleeBattle();
        LOG.info("Clubbed troll attack power:{}", troll.getAttackPower());
    }
}
