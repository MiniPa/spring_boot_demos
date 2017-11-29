package com.minipa.sbd.mybatis.multisrcs.entity;


import com.minipa.sbd.mybatis.multisrcs.enums.SexEnum;

import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String userName;
	private String passWord;
	private SexEnum userSex;
	private String nickName;

	public User() {
		super();
	}

	public User(String userName, String passWord, SexEnum userSex) {
		super();
		this.passWord = passWord;
		this.userName = userName;
		this.userSex = userSex;
	}

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

	public SexEnum getUserSex() {
		return userSex;
	}

	public void setUserSex(SexEnum userSex) {
		this.userSex = userSex;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	@Override
	public String toString() {
		return "userName " + this.userName + ", pasword " + this.passWord + "sex " + userSex.name();
	}

}