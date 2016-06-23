package com.goforit.firstapple.common.exception;

/**
 * Created by junqingfjq on 16/6/23.
 */
public class UserRegisterError extends RuntimeException {

    public UserRegisterError(String message){
        super(message);
    }
}
