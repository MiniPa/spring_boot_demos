package com.minipa.sbd.scheduler.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * SchedulerTask2:
 *
 * @Scheduled(fixedRate = 6000) ：上一次开始执行时间点之后6秒再执行
 * @Scheduled(fixedDelay = 6000) ：上一次执行完毕时间点之后6秒再执行
 * @Scheduled(initialDelay=1000, fixedRate=6000) ：第一次延迟1秒后执行，之后按fixedRate的规则每6秒执行一次
 *
 * @author: <a href="mailto:chengjs@servyou.com.cn">chengjs</a>
            <a href="https://github.com/MiniPa">minipa_github</a>
 * @version: 1.0.0, 2017-12-04 shared by all free coders
 **/
@Component
public class SchedulerTask2 {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 3000)
    public void process() {
        System.out.println("SchedulerTask2.porcess new date() ：" + dateFormat.format(new Date()));
    }

}
