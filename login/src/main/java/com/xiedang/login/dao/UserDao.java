package com.xiedang.login.dao;

import com.xiedang.login.model.User;

import java.util.List;

/**
 * Created by xiedang on 2016/12/7.
 */
public interface UserDao {
     List<User> getAllUsers();
     User findUserById(int id);
}
