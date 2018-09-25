package com.jack.dao;

import com.jack.entity.User;

public interface UserDao {

    User getUserByUsername(String username);

    User getUserById(String id);

    void update(User user);

    void save(User user);
}
