package com.minipa.sbd.web.filter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * DemoFilter: 自定义Filter
 * <p>
 * filters用于录调用日志、排除有XSS威胁的字符、执行权限验证等等
 * Spring Boot自动添加了OrderedCharacterEncodingFilter和HiddenHttpMethodFilter
 *
 * SB FIlter
 * 1.DemoFilter Implements Filter
 * 2.添加@Configurationz 注解，将自定义Filter加入过滤链 @WebConfiguration
 *
 * @version 0.0.1  @date: 2017-11-24
 * @author: <a href="mailto:chengjs_minipa@outlook.com">chengjs_minipa</a>,
 */
public class DemoFilter implements Filter {

  @Override
  public void destroy() {
    // TODO Auto-generated method stub
  }

  @Override
  public void doFilter(ServletRequest srequest, ServletResponse sresponse, FilterChain filterChain)
      throws IOException, ServletException {
    HttpServletRequest request = (HttpServletRequest) srequest;
    System.out.println("DemoFilter.doFIlter() ,url :"+request.getRequestURI());
    filterChain.doFilter(srequest, sresponse);
  }

  @Override
  public void init(FilterConfig arg0) throws ServletException {
    // TODO Auto-generated method stub
  }

}
