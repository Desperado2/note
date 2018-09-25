package com.jack.controller;

import com.jack.common.Result;
import com.jack.encrypt.EncryptUtil;
import com.jack.entity.User;
import com.jack.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("user")
public class UserJson {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Result save(User user){
        return userService.save(user);
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Result login(String username,String password,HttpServletRequest request) {
        Result result = userService.login(username, password);
        if(result.isSuccess()){
            User data = (User) result.getData();
            String token = EncryptUtil.getToken(username, data.getPassword());
            request.getSession().setAttribute("token",token);
            request.getSession().setAttribute("user",data.getId());
        }
        return result;
    }

    @RequestMapping(value = "/checkEmail/{id}",method = RequestMethod.GET)
    public Result sendEmail(@PathVariable String id){
        return userService.checkEmail(id);
    }

    @RequestMapping(value = "/validLogin",method = RequestMethod.GET)
    public Boolean validLogin(String id,HttpServletRequest request){
        if(request.getSession().getAttribute("token") != null){
            return true;
        }
        return false;
    }

}
