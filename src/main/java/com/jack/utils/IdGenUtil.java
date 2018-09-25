package com.jack.utils;

import java.util.UUID;

public class IdGenUtil {

    public static String getId(){
        return UUID.randomUUID().toString();
    }

    public static String getSalt(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }
}
