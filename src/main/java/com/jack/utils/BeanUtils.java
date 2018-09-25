package com.jack.utils;

import com.jack.entity.User;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class BeanUtils {

    public static <T> List<T> copyBean(List<T> source, List<T> target) {
        if (!CollectionUtils.isEmpty(source)) {
            for (Object object : source) {
                target.add((T) object);
            }
        }
        return target;
    }

    public static void main(String[] args) {
        User user = new User();
        user.setId("1");
        List<User> list = new ArrayList<>();
        List<User> list1 = new ArrayList<>();
        list.add(user);
        copyBean(list,list1);
        System.out.println(list);
    }
}
