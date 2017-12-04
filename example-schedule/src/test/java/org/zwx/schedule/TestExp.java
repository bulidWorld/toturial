package org.zwx.schedule;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import java.util.concurrent.TimeUnit;

@ContextConfiguration(locations = "classpath:spring-schedule.xml")
public class TestExp extends AbstractJUnit4SpringContextTests {

    @Autowired
    private SchedulerFactoryBean schFactory;

    @Test
    public void test1() {
        System.out.println("---test");
    }

    @Test
    public void testSchedule() throws InterruptedException {
//        Scheduler scheduler = schFactory.getObject();
//        schFactory.start();
        TimeUnit.SECONDS.sleep(2000);
    }
}
