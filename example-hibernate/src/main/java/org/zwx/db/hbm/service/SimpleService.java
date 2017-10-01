package org.zwx.db.hbm.service;

import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronization;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import org.zwx.db.hbm.repository.SimpleDao;
import org.zwx.db.hbm.resource.SimpleSource;

import java.util.function.Consumer;

@Service
public class SimpleService {

    @Autowired
    private SimpleDao simpleDao;


    @Transactional(timeout = 7)
    public void savePhillo() {
//        simpleDao.saveAction(SimpleSource.action);
        simpleDao.savePersion(SimpleSource.person);
//        simpleDao.saveAction(SimpleSource.action);
        simpleDao.saveActionWithDelay(SimpleSource.action);
    }


    /**
     * 测试一个有事务，一个没事务，最终有事务
     */
    @Transactional
    public void save1() {
        simpleDao.savePersion(SimpleSource.person);
        simpleDao.saveActionWithoutTransac(SimpleSource.action);
    }


    /**
     * 测试一个new req
     */
    @Transactional
    public void save2() {
        simpleDao.savePersion(SimpleSource.person);
        simpleDao.saveActionWithNewReq(SimpleSource.action);
        simpleDao.savePersion(SimpleSource.person);
        simpleDao.savePerson2(SimpleSource.person);

    }


    @Transactional
    public <T> void testRollbackEvent(Consumer<T> c) {

        TransactionSynchronizationManager.registerSynchronization(TransactionEventFactory.getRollBackEvent(c));

        simpleDao.saveAction(SimpleSource.action);

    }

}
