package com.zf.service.impl;

import com.zf.dao.UserMapper;
import com.zf.model.User;
import com.zf.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService{
    @Resource
    private UserMapper userMapper;

    @Override
    public boolean addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public User queryByName(String name) {
        return userMapper.queryByName(name);
    }
}
