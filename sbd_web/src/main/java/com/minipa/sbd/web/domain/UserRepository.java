package com.minipa.sbd.web.domain;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * UserRepository:
 * dao 只要extends JpaRepository即可
 * 根据方法名来自动产生SQL
 *
 * @author: <a href="mailto:chengjs_minipa@outlook.com">chengjs</a>, version:1.0.0, 2017/11/24
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserName(String userName);

    User findByUserNameOrEmail(String username, String email);
    
}