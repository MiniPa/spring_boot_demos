package com.minipa.sbd.mongodb.dao.impl;

import com.minipa.sbd.mongodb.dao.IUserDao;
import com.minipa.sbd.mongodb.entity.User;
import com.mongodb.WriteResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

/**
 * UserDaoImpl:
 *
 * @author: <a href="mailto:chengjs@servyou.com.cn">chengjs</a>
 * <a href="https://github.com/MiniPa">minipa_github</a>
 * @version: 1.0.0, 2017-12-04 shared by all free coders
 **/
@Component
public class UserDaoImpl implements IUserDao {

  @Autowired
  private MongoTemplate mongoTemplate;

  @Override
  public void saveUser(User user) {
    mongoTemplate.save(user);
  }

  @Override
  public User findUserByUserName(String userName) {
    Query query = new Query(Criteria.where("userName").is(userName));
    User user = mongoTemplate.findOne(query, User.class);
    return user;
  }

  @Override
  public int updateUser(User user) {
    Query query = new Query(Criteria.where("id").is(user.getId()));
    Update update = new Update().set("userName", user.getUserName()).set("passWord", user.getPassWord());

    /*1.更新返回结果集第一条*/
    WriteResult result = mongoTemplate.updateFirst(query, update, User.class);
    /*2.更新返回结果集全部*/
    // mongoTemplate.updateMulti(query,update,User.class);
    if (result != null) {
      return result.getN();
    } else {
      return 0;
    }
  }

  @Override
  public void deleteUserById(Long id) {
    Query query = new Query(Criteria.where("id").is(id));
    mongoTemplate.remove(query, User.class);
  }
}
