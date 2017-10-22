package org.zwx.dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.zwx.config.Boot;
import org.zwx.model.Person;

import java.util.HashMap;
import java.util.Map;

public class PersonDao {


    public Person getPerson(int id) {
        SqlSession session = Boot.getSqlSessionFactory().openSession();
        Person p = session.selectOne("findById", id);
        return p;
    }


    public Person getPerson(Map param) {
        SqlSession session = Boot.getSqlSessionFactory().openSession();
        Person p = session.selectOne("findById", param);
        return p;
    }


    @Test
    public void test() {
        System.out.println(getPerson(123));
    }

    @Test
    public void testMap() {
        Map map = new HashMap();
        map.put("id", 123);

        System.out.println(getPerson(map));
    }
}
