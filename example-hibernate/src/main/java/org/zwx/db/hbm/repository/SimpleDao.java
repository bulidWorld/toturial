package org.zwx.db.hbm.repository;


import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.zwx.db.hbm.module.Action;
import org.zwx.db.hbm.module.Person;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

@Repository
public class SimpleDao {

    @Autowired
    private LocalSessionFactoryBean localSessionFactoryBean;


    public Session getSession() {
        return localSessionFactoryBean.getObject().getCurrentSession();
    }

    @Transactional
    public Serializable savePersion(Person p) {
        Serializable serializable = null;
        Session session = getSession();
        serializable = session.save(p);
        return serializable;
    }

    @Transactional
    public void saveAction(Action action) {
        getSession().save(action);
    }

    @Transactional
    public void test2(Person p, Action action) {
        savePersion(p);
        saveAction(action);
    }

    @Transactional
    public void saveActionWithExp(Action action) {
        getSession().save(action);
        throw new RuntimeException("action exp");
    }

    public void saveActionWithDelay(Action action) {
        getSession().save(action);
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void saveActionWithoutTransac(Action action) {
        getSession().save(action);
        throw new RuntimeException("action exp");
    }


    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void saveActionWithNewReq(Action action) {
        getSession().save(action);
       // throw new RuntimeException("action exp");
    }

    public void savePerson2(Person person) {
        getSession().save(person);
        throw new RuntimeException("111");
    }

    @Transactional
    public void savePersonWithExp(Person person) {
        getSession().save(person);
        throw new RuntimeException("hello exp");
    }

}
