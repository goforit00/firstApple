package com.goforit.firstapple.user.service;

import com.goforit.firstapple.user.model.User;
import com.goforit.firstapple.user.model.UserToken;
import com.goforit.firstapple.user.model.enums.UserLoginType;
import com.goforit.firstapple.user.model.enums.UserType;

/**
 * Created by junqingfjq on 16/6/23.
 */
public interface UserService {

    User register(User user);

    UserToken mailRegisterOver(String username,String token);

    UserToken login(String userInfo,String password,UserLoginType loginType, UserType userType);

    boolean logout(String token);

    User verifyToken(String token);
}
