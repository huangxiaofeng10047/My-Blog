package com.site.blog.my.core;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

/**
 * @author huangxf168482
 * @version 1.0
 * @date 2020/01/27 16:24
 */
@Configuration
//@EnableScheduling
public class ScheduleConfig implements SchedulingConfigurer {

    @Override

    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {

        scheduledTaskRegistrar.setScheduler(new ScheduledThreadPoolExecutor(Runtime.getRuntime().availableProcessors(),

            new ThreadFactory() {

                @Override

                public Thread newThread(Runnable r) {

                    return new Thread(r, "my-schedule");

                }

            }));

    }

}
