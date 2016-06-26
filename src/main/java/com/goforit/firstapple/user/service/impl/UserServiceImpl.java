package com.goforit.firstapple.user.service.impl;

import com.goforit.firstapple.common.utils.MailSender;
import com.goforit.firstapple.user.manager.UserManager;
import com.goforit.firstapple.user.model.User;
import com.goforit.firstapple.user.model.UserOperationToken;
import com.goforit.firstapple.user.model.UserToken;
import com.goforit.firstapple.user.model.enums.UserLoginType;
import com.goforit.firstapple.user.model.enums.UserOperationType;
import com.goforit.firstapple.user.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * Created by junqingfjq on 16/6/23.
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserManager userManager;

    @Autowired
    private MailSender mailSender;

    private TransactionTemplate transactionTemplate;

    @Override
    public User register(final User user) {

        User registerUser=transactionTemplate.execute(new TransactionCallback<User>() {
            @Override
            public User doInTransaction(TransactionStatus status) {
                // send mail
                User registerUser=userManager.register(user);

                // send email
                userManager.sendUserRegisterMail(user.getUsername(),user.getEmail());

                return registerUser;
            }
        });

        return registerUser;
    }

    @Override
    public UserToken mailRegisterOver(String username, String token) {

        UserOperationToken userOperationToken = userManager.getLatest(username,
            UserOperationType.USER_REGISTER_OPERATION);

        if (StringUtils.equals(token, userOperationToken.getToken())) {
            User user=userManager.registerOver(username,true);

            return userManager.generatorUserToken(user.getId());

        }else {
            userManager.registerOver(username,false);
            return null;
        }
    }

    @Override
    public UserToken login(String username, String password,UserLoginType loginType) {
        return userManager.Login(username,password,loginType);
    }

    @Override
    public User verifyToken(String token) {
        return userManager.verifyToken(token);
    }


}
