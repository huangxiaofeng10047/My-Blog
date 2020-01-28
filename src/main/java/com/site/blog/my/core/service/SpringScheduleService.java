package com.site.blog.my.core.service;

import java.util.concurrent.TimeUnit;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author huangxf168482
 * @version 1.0
 * @date 2020/01/27 16:06
 */
@Slf4j
@Service
public class SpringScheduleService {
    @Scheduled(fixedDelay = 1000)
  public void fixDelayMethod() throws  InterruptedException{
      log.info("start run fix delay method");
      TimeUnit.SECONDS.sleep(600);
  }
  @Scheduled(cron = "1/2 * * * * ?")
  public  void cronMethod(){
    log.info("start run cron method");
  }
}
