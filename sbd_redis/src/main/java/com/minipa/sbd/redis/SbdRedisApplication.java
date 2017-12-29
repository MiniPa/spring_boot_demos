package com.minipa.sbd.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *  Redis: 使用最广泛的内存数据存储 支持的数据结构丰富, 支持数据持久化
 *  Redis还提供一些类数据库的特性，比如事务，HA，主从库
 */
@SpringBootApplication
public class SbdRedisApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbdRedisApplication.class, args);
	}

}
