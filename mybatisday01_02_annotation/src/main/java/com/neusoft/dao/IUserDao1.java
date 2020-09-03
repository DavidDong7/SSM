package com.neusoft.dao;

import com.neusoft.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IUserDao1 {
    @Select("select * from user")
    List<User> findAll();
}
