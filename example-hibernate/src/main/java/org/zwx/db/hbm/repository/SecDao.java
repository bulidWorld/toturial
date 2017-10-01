package org.zwx.db.hbm.repository;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.zwx.db.hbm.module.SecKillGoods;
import org.zwx.db.hbm.module.SecKillOrders;

import java.io.Serializable;
import java.util.List;

@Repository
@Transactional
public class SecDao {

    @Autowired
    private LocalSessionFactoryBean localSessionFactoryBean;

    private Session getSession() {
        return localSessionFactoryBean.getObject().getCurrentSession();
    }


    public List<SecKillGoods> getGoods() {
        return getSession().createQuery("from SecKillGoods", SecKillGoods.class).list();
    }

    public void updateGood(SecKillGoods good) {
        getSession().update(good);
    }


    public Serializable saveOrder(SecKillOrders order) {
        return getSession().save(order);
    }


}
