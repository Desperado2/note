package com.jack.encrypt;

import org.springframework.util.DigestUtils;

public class EncryptUtil {

    public static String getEncrypt(String text,String salt){
        String s = text + salt;
        String digest = DigestUtils.md5DigestAsHex(s.getBytes());
        return digest;
    }

    public static String getToken(String username, String password){
        String s = password + username;
        return DigestUtils.md5DigestAsHex(s.getBytes());
    }
}
