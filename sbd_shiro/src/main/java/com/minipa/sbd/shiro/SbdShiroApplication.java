package com.minipa.sbd.shiro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * SbdShiroApplication:
 *
 * @ComponentScan 定义扫描包位置
 *    @SpringBootApplication 默认扫描坐在包与子包,按理说@ComponentScan可以不用,但在这里不用会报错,不知道为啥
 *
 * @author: <a href="mailto:chengjs@servyou.com.cn">chengjs</a>
 *          <a href="https://github.com/MiniPa">minipa_github</a>
 * @version: 1.0.0, 2017-12-06 shared by all free coders
 *
 * @ComponentScan(basePackages = "com.minipa.sbd.shiro.entity")
 **/
@SpringBootApplication
public class SbdShiroApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbdShiroApplication.class, args);
	}

}
