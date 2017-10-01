package org.zwx.db.hbm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zwx.db.hbm.module.SecKillGoods;
import org.zwx.db.hbm.module.SecKillOrders;
import org.zwx.db.hbm.repository.SecDao;

@Service
public class SecGoodService {

    @Autowired
    private SecDao secDao;

    @Transactional
    public void secGoods(SecKillGoods good, String customer, int secNum) {
        SecKillOrders secKillOrder = new SecKillOrders();
        secKillOrder.setCustomer(customer);
        secKillOrder.setGoodsId(good.getId());
        secKillOrder.setNum(secNum);

        good.setRemainNum(good.getRemainNum() - secNum);
        secDao.saveOrder(secKillOrder);
        secDao.updateGood(good);

    }

}

