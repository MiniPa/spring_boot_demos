package com.minipa.sbd.mybatis.multisrcs.mapper.test2;

import com.minipa.sbd.mybatis.multisrcs.entity.User;
import com.minipa.sbd.mybatis.multisrcs.enums.SexEnum;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface User2Mapper {

	@Select("SELECT * FROM users")
	@Results({
			@Result(property = "userSex",  column = "user_sex", javaType = SexEnum.class),
			@Result(property = "nickName", column = "nick_name")
	})
  List<User> getAll();

	@Select("SELECT * FROM users WHERE id = #{id}")
	@Results({
			@Result(property = "userSex",  column = "user_sex", javaType = SexEnum.class),
			@Result(property = "nickName", column = "nick_name")
	})
	User getOne(Long id);

	@Insert("INSERT INTO users(userName,passWord,user_sex) VALUES(#{userName}, #{passWord}, #{userSex})")
	void insert(User user);

	@Update("UPDATE users SET userName=#{userName},nick_name=#{nickName} WHERE id =#{id}")
	void update(User user);

	@Delete("DELETE FROM users WHERE id =#{id}")
	void delete(Long id);

}