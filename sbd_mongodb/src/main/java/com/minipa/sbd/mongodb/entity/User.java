package com.minipa.sbd.mongodb.entity;

import java.io.Serializable;

/**
 * User:
 *
 * @author: <a href="mailto:chengjs@servyou.com.cn">chengjs</a>
 * <a href="https://github.com/MiniPa">minipa_github</a>
 * @version: 1.0.0, 2017-12-04 shared by all free coders
 **/
public class User implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long id;
  private String userName;
  private String passWord;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassWord() {
    return passWord;
  }

  public void setPassWord(String passWord) {
    this.passWord = passWord;
  }

  @Override
  public String toString() {
    return "User{" +
        "id=" + id +
        ", userName='" + userName + '\'' +
        ", passWord='" + passWord + '\'' +
        '}';
  }

}
