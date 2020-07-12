package com.practise.service.impl;

import com.practise.dao.UserDao;
import com.practise.dao.impl.UserDaoImpl;
import com.practise.entity.User;
import com.practise.service.UserService;

/**
 * @Auther: tsh
 * @program: tianshuo
 * @Description:
 * @Date: 2020/7/10 13:33
 **/
public class UserServiceImpl implements UserService {
    private UserDao userDao= new UserDaoImpl();
    @Override
    public int saveUser(User user) {
        int flag = userDao.saveUser(user);
        return flag;
    }

    @Override
    public User signUser(User user) {
        User user1=userDao.signUser(user);
        return user1;
    }

    @Override
    public void selectUser(User user) {

    }
}
