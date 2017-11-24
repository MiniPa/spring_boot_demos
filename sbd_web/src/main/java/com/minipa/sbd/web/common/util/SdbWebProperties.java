package com.minipa.sbd.web.common.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * SdbWebProperties:
 *
 * SB(代指Spring Boot) 自定义配置类
 * 1.配置在application.properties中
 * 2.自定义配置类 @Component
 *
 * @author: <a href="mailto:chengjs_minipa@outlook.com">chengjs</a>, version:1.0.0, 2017/11/24
 */
@Component
public class SdbWebProperties {
	
	@Value("${sbd.web.title}")
	private String title;

	@Value("${sbd.web.description}")
	private String description;

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
