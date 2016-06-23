package com.goforit.firstapple.user.service;

import com.goforit.firstapple.common.result.FacadeResult;
import com.goforit.firstapple.user.model.User;

/**
 * Created by junqingfjq on 16/6/23.
 */
public interface UserService {

    FacadeResult<User> register(User user);

    String mailRegisterOver(String username,String token);
}
