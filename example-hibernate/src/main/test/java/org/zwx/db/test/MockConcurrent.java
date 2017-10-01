package org.zwx.db.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.zwx.db.hbm.module.SecKillGoods;
import org.zwx.db.hbm.repository.SecDao;
import org.zwx.db.hbm.service.SecGoodService;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MockConcurrent extends DBTestEnv {

    @Autowired
    private SecGoodService secGoodService;

    @Autowired
    private SecDao secDao;

    @Test
    public void testConcu() throws InterruptedException {






    }

    @Test
    public void testCurr() throws InterruptedException {
        for (int i = 0; i < 50; i++) {
            final int j = i;
            Thread t = new Thread(() -> {
                try {
                    List<SecKillGoods> li = secDao.getGoods();

                    SecKillGoods good = li.get(0);

                    org.testng.Assert.assertEquals(li.size(), 1);


                    if (good.getRemainNum() > 0) {
                        TimeUnit.SECONDS.sleep(5);
                        secGoodService.secGoods(good, "zhiwenxia" + j, 1);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            t.start();


        }

    }
}
