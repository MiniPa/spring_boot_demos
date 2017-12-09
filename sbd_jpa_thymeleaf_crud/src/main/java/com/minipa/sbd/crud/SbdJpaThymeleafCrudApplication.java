package com.minipa.sbd.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class SbdJpaThymeleafCrudApplication extends SpringBootServletInitializer {

  public static void main(String[] args) {
    SpringApplication.run(SbdJpaThymeleafCrudApplication.class, args);
  }

  /**
   * 添加Servlet支持
   *
   * @param application
   * @return
   */
  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    return application.sources(SbdJpaThymeleafCrudApplication.class);
  }

}
