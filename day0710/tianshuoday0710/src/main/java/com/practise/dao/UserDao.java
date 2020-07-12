package com.practise.dao;

import com.practise.entity.User;

/**
 * @Auther: tsh
 * @program: tianshuo
 * @Description:
 * @Date: 2020/7/10 13:35
 **/
public interface UserDao {
    int saveUser(User user);

    User signUser(User user);
    void selectUser(User user);
}
