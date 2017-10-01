package org.zwx.db.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;
import org.zwx.db.hbm.module.Person;
import org.zwx.db.hbm.repository.SimpleDao;

public class SimpleTest extends DBTestEnv {

    @Autowired
    private SimpleDao simpleDao;

    @Test
    public void test() {
        Person p = new Person();
        p.setId(26);
        p.setAge(12);
        System.err.println(simpleDao.savePersion(p));
    }
}
