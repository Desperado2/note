package com.jack.service;

import com.jack.common.Result;
import com.jack.entity.User;

public interface UserService {

    Result login(String username, String password);

    Result checkEmail(String id);

    Result update(User user);

    Result save(User user);
}
