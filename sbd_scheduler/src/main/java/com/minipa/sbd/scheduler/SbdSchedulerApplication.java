package com.minipa.sbd.scheduler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * SbdSchedulerApplication:
 *
 * 1.SprinbBoot 自带定时任务, 引入 starter即可
 *
 *
 * @author: <a href="mailto:chengjs@servyou.com.cn">chengjs</a>
            <a href="https://github.com/MiniPa">minipa_github</a>
 * @version: 1.0.0, 2017-12-04 shared by all free coders
 **/
@SpringBootApplication
@EnableScheduling
public class SbdSchedulerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbdSchedulerApplication.class, args);
	}
}
