package com.goforit.firstapple.user.service;

import com.goforit.firstapple.user.model.User;
import com.goforit.firstapple.user.model.UserToken;
import com.goforit.firstapple.user.model.enums.UserLoginType;

/**
 * Created by junqingfjq on 16/6/23.
 */
public interface UserService {

    User register(User user);

    UserToken mailRegisterOver(String username,String token);

    UserToken login(String userInfo,String password,UserLoginType loginType);

    User verifyToken(String token);
}
