package com.zf.service;

import com.zf.model.User;

public interface UserService {
    boolean addUser(User user);
    User queryByName(String name);
}
