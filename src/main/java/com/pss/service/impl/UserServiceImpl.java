package com.pss.service.impl;

import com.pss.bean.User;
import com.pss.dao.UserDao;
import com.pss.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserServiceImpl() {
    }

    @Override
    public User login(@Param("loginname")String loginname, @Param("password")String password) {
        return userDao.login(loginname,password);
    }

    @Override
    public List<User> getAll(@Param("key") String key) {
        return userDao.getAll(key);
    }

    @Override
    public int add(@Param("user") User user) {
        return userDao.add(user);
    }

    @Override
    public int deleted(int id) {
        return userDao.deleted(id);
    }

    @Override
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    @Override
    public int update(User user) {
        return userDao.update(user);
    }
}
