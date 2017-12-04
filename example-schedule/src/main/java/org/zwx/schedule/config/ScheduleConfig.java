package org.zwx.schedule.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
@EnableAsync
public class ScheduleConfig {


    @Scheduled(cron = "0/3 * * * * ?")
    public void SimpleAnnotaionSchedule() {
        System.out.println("simple annotation schedule");
    }
}
