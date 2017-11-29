package com.minipa.sbd.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SbdMybatisApplication:
 *
 * @MapperScan 也可直接在Mapper类上加 @Mapper
 *
 * @author: <a href="mailto:chengjs@servyou.com.cn">chengjs</a>
 * @version: 1.0.0, 2017-11-29
 *
 * ALL RIGHTS RESERVED,COPYRIGHT(C) FCH LIMITED Shanghai Servyou Ltd 2017
 **/
@SpringBootApplication
@MapperScan("com.minipa.sbd.mybatis.mapper")
public class SbdMybatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbdMybatisApplication.class, args);
	}

}
