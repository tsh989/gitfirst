package com.practise.service;

import com.practise.entity.User;

/**
 * @Auther: tsh
 * @program: tianshuo
 * @Description:
 * @Date: 2020/7/10 13:26
 **/
public interface UserService {
    int saveUser(User user);
    User signUser(User user);
    void selectUser(User user);
}
