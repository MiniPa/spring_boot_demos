package com.minipa.sbd.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * SbdJpaApplication:
 *
 * 启动类继承自SpringBootServletInitializer方可正常部署至常规tomcat下，其主要能够起到web.xml的作用
 *
 * @author: <a href="mailto:chengjs@servyou.com.cn">chengjs</a>
 * @version: 1.0.0, 2017-11-28
 *
 * ALL RIGHTS RESERVED,COPYRIGHT(C) FCH LIMITED Shanghai Servyou Ltd 2017
 **/
@SpringBootApplication
public class SbdJpaApplication extends SpringBootServletInitializer {

  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    return application.sources(SbdJpaApplication.class);
  }

	public static void main(String[] args) {
		SpringApplication.run(SbdJpaApplication.class, args);
	}

}
