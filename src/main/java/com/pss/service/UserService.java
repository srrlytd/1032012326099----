package com.pss.service;

import com.pss.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {
    User login(String loginname,String password);
    List<User> getAll(@Param("key") String key);
    int add(@Param("user") User user);
    int deleted(@Param("id") int id);
    User getUserById(@Param("id") int id);
    int update(@Param("user") User user);
}
