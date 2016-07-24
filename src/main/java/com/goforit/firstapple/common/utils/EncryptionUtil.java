package com.goforit.firstapple.common.utils;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.MessageDigest;

/**
 * Created by junqingfjq on 16/6/24.
 */
public class EncryptionUtil {

    public static final Logger LOGGER= LoggerFactory.getLogger(EncryptionUtil.class);

    public static String encryptMD5(String password){
        try{
            if(StringUtils.isBlank(password)){
                return null;
            }
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(password.getBytes());
            return new String(md5.digest()).toUpperCase();
        }catch (Exception e){
            //TODO
            e.printStackTrace();
            return null;
        }
    }
}