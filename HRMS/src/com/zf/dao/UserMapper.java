package com.zf.dao;

import com.zf.model.User;

public interface UserMapper {
    boolean addUser(User user);
    User queryByName(String name);
}
