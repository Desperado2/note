package com.jack.service.impl;

import com.jack.common.Result;
import com.jack.dao.UserDao;
import com.jack.encrypt.EncryptUtil;
import com.jack.entity.User;
import com.jack.service.EamilService;
import com.jack.service.UserService;
import com.jack.utils.IdGenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;
    @Override
    public Result login(String username, String password) {

        if(StringUtils.isEmpty(username) || StringUtils.isEmpty(password)){
            return Result.fail("参数错误");
        }
        User user = userDao.getUserByUsername(username);
        if(user == null){
            return Result.fail("用户不存在");
        }
        if(user.getActiveFlag() == 0){
            return Result.fail("用户没有激活");
        }
        password =EncryptUtil.getEncrypt(password,user.getSalt());
        if(password.equals(user.getPassword())){
            return Result.success(user);
        }
        return Result.fail("用户名或密码错误");
    }

    @Override
    public Result checkEmail(String id) {
        if(StringUtils.isEmpty(id)){
            return Result.fail("参数错误");
        }
        User user = userDao.getUserById(id);
        if(user == null){
            return Result.fail("用户不存在");
        }
        user.setActiveFlag(1);
        userDao.update(user);
        return Result.success(user);
    }

    @Override
    public Result update(User user) {
        return null;
    }

    @Override
    public Result save(User user) {
        if(user == null){
            return Result.fail("参数错误");
        }
        User user1 = userDao.getUserByUsername(user.getUsername());
        if(user1 != null){
            return Result.fail("用户名已存在");
        }
        String salt = IdGenUtil.getSalt();
        user.setId(IdGenUtil.getId());
        user.setDeleteFlag(0);
        user.setActiveFlag(0);
        user.setCreateDate(new Date());
        user.setPassword(EncryptUtil.getEncrypt(user.getPassword(),salt));
        user.setSalt(salt);
        userDao.save(user);
        EamilService.send(user,"http://localhost:8080/user/checkEmail/"+user.getId());
        return Result.success(user);
    }
}
