package com.minipa.sbd.mybatis.mapper;

import com.minipa.sbd.mybatis.entity.User;
import com.minipa.sbd.mybatis.enums.UserSexEnum;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.springframework.dao.DataAccessException;

import java.util.List;

/**
 * UserMapper: Mybatis 注解方式数据交互
 *
 * 参考文档： http://www.mybatis.org/mybatis-3/java-api.html
 *
 * @author: <a href="mailto:chengjs@servyou.com.cn">chengjs</a>
 * @version: 1.0.0, 2017-11-29
 *
 * ALL RIGHTS RESERVED,COPYRIGHT(C) FCH LIMITED Shanghai Servyou Ltd 2017
 **/
@Mapper
public interface UserMapper {
	
	@Select("SELECT * FROM users")
	@Results({
		@Result(property = "userSex",  column = "user_sex", javaType = UserSexEnum.class),
		@Result(property = "userName", column = "user_name")
	})
  List<User> getAll();
	
	@Select("SELECT * FROM users WHERE id = #{id}")
	@Results({
		@Result(property = "userSex",  column = "user_sex", javaType = UserSexEnum.class),
		@Result(property = "userName", column = "user_name")
	})
	User getOne(Long id);

	@Insert("INSERT INTO users(id,user_name,pass_word,user_sex) VALUES(#{id},#{userName}, #{passWord}, #{userSex})")
	void insert(User user);

	@Update("UPDATE users SET user_name=#{userName},nick_name=#{nickName} WHERE id =#{id}")
	void update(User user);

	@Delete("DELETE FROM users WHERE id =#{id}")
	void delete(Long id);


  /**
   * @SelectKey 查询一下需要的前置字段,插入到下一句中
   * @param user
   * @return
   * @throws DataAccessException
   */
  @SelectKey(statement = "select max(id) from t_id", before = true, resultType = long.class, keyProperty = "id")
  @Insert("insert into t_user(id,user_name,user_sex) values (#{id},#{userName},#{userSex})")
  public int addUser(User user) throws DataAccessException;

}