package org.zwx.db.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;
import org.zwx.db.hbm.module.Action;
import org.zwx.db.hbm.module.Person;
import org.zwx.db.hbm.repository.SimpleDao;
import org.zwx.db.hbm.resource.SimpleSource;
import org.zwx.db.hbm.service.SimpleService;

import java.util.HashMap;
import java.util.Map;

public class TestTransaction extends DBTestEnv{

    @Autowired
    private SimpleDao simpleDao;

    @Autowired
    private SimpleService simpleService;
    @Test
    public void test() {
        Person p = new Person("大师", 101, 1L);
        simpleDao.savePersion(p);

        Action action = new Action("大师之道", "大道","道","无心" );
        simpleDao.saveAction(action);
    }

    @Test
    public void tests() {
        Person p = new Person("大师", 101, 1L);
        Action action = new Action("大师之道", "大道","道","无心" );

        simpleDao.test2(p, action);
    }

    @Test
    public void testTransacByService() {
        simpleService.savePhillo();
    }


    @Test
    public void test2() {
        simpleService.save1();
    }


    @Test
    public void test3() {
        simpleService.save2();
    }


    @Test
    public void testRegistRollBackEvent() {
        Map map = new HashMap();
        map.put("1", "No1");
        map.put("2", "No2");
        simpleService.testRollbackEvent(System.out::println);
        simpleDao.savePersonWithExp(SimpleSource.person);
    }


}
