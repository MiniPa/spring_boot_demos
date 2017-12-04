package com.minipa.sbd.scheduler.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * SchedulerTask1:
 * 
 * @author: <a href="mailto:chengjs@servyou.com.cn">chengjs</a>
            <a href="https://github.com/MiniPa">minipa_github</a>
 * @version: 1.0.0, 2017-12-04 shared by all free coders 
 **/
@Component
public class SchedulerTask1 {

    private int count=0;

    @Scheduled(cron="*/3 * * * * ?")
    private void process(){
        System.out.println("SchedulerTask1.process runing  "+(count++));
    }

}
