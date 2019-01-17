package com.xiedang.login.service;

import java.io.Serializable;

/**
 * Created by xiedang on 2017/2/10.
 */
public interface UserService<T extends Serializable> {
    T findById(int id);
}
