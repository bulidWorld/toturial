package org.zwx.db.hbm.resource;

import org.zwx.db.hbm.module.Action;
import org.zwx.db.hbm.module.Person;

public class SimpleSource {

    public static Person person;

    public static Action action;

    static {
        person = new Person("大师", 101, 1L);
        action = new Action("大师之道", "大道", "道", "无心");
    }

}
