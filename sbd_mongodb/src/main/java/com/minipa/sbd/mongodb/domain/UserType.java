package com.minipa.sbd.mongodb.domain;

public enum UserType {
	
	EMPLOYEE("员工个人账号"),
	COMPANY("公司职能账号");
	
	private String description;
	
	UserType(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
