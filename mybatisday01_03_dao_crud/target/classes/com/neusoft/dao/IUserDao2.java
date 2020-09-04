package com.neusoft.dao;

import com.neusoft.domain.User;

import java.util.List;

public interface IUserDao2 {

    //查询所有
    List<User> findAll();

    //按id查询
    User findById(Integer id);

//    返回自增长id值
    int saveUser(User user);

    //修改
    int updateUser(User user);

    //删除
    int deleteUser(Integer id);

    //模糊查询
    List<User> findByName(String username);

    //查询总记录数
    int findTotal();
}
