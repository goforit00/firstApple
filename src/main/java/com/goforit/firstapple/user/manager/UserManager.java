package com.goforit.firstapple.user.manager;

import com.goforit.firstapple.common.exception.UserRegisterError;
import com.goforit.firstapple.user.model.User;
import com.goforit.firstapple.user.model.UserOperationToken;
import com.goforit.firstapple.user.model.UserToken;
import com.goforit.firstapple.user.model.enums.UserLoginType;
import com.goforit.firstapple.user.model.enums.UserOperationType;

/**
 * Created by junqingfjq on 16/6/23.
 */
public interface UserManager {

    User register(User user) throws UserRegisterError;

    User registerOver(String username,boolean isSuccessful);

    UserOperationToken generateUserOperationToken(String username,UserOperationType type);

    UserOperationToken getLatest(String username,UserOperationType type);

    boolean sendUserRegisterMail(String username,String userMail);

    UserToken Login(String userInfo,String password,UserLoginType loginType);

    User verifyToken(String token);

    UserToken generatorUserToken(String userId);
}
