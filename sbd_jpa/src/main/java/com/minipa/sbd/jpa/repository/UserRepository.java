package com.minipa.sbd.jpa.repository;

import com.minipa.sbd.jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * UserRepository:
 * 
 * @author: <a href="mailto:chengjs@servyou.com.cn">chengjs</a>
 * @version: 1.0.0, 2017-11-28 
 * 
 * ALL RIGHTS RESERVED,COPYRIGHT(C) FCH LIMITED Shanghai Servyou Ltd 2017
 **/
public interface UserRepository extends JpaRepository<User, Long> {

    User findById(long id);

    Long deleteById(Long id);

}