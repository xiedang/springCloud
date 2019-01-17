package com.xiedang.login.service.impl;

import com.xiedang.login.dao.UserDao;
import com.xiedang.login.model.User;
import com.xiedang.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author xiedang
 * @date 2017/2/10
 */
@Service
public class UserServiceImpl implements UserService<User> {
    @Autowired
    private UserDao userDao;
    @Override
    public User findById(int id) {
        return userDao.findUserById(id);
    }
}
