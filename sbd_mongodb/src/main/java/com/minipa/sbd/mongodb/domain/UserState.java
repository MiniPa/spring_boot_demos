package com.minipa.sbd.mongodb.domain;

public enum UserState {
	
	ACTIVE("活跃"),
	INACTIVE("不活跃"),
	RESIGNED("离职");
	
	private String value;
	
	UserState(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}
}
