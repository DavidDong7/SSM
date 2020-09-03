package com.neusoft.dao;

import com.neusoft.domain.User;

import java.util.List;

public interface IUserDao2 {

    List<User> findAll();

   User findById(Integer id);
}
