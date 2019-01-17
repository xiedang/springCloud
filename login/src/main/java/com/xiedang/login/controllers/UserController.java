package com.xiedang.login.controllers;

import com.xiedang.login.dao.UserDao;
import com.xiedang.login.model.User;
import com.xiedang.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 *
 * @author xiedang
 * @date 2017/2/9
 */
@Controller
@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
public class UserController {
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserService<User> userService;

    @GetMapping(value = "/userList")
    @ResponseBody
    public List<User> showUsers() {
        List<User> users = userDao.getAllUsers();
        return users;
    }

    @ResponseBody
    @GetMapping(value = "/{id}/show")
    public User showUser(@PathVariable("id") int id) {
        User user = userService.findById(id);
        return user;
    }
}
