package com.goforit.firstapple.user.service.impl;

import com.goforit.firstapple.user.model.UserOperationToken;
import com.goforit.firstapple.user.model.enums.UserOperationType;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

import com.goforit.firstapple.common.result.FacadeResult;
import com.goforit.firstapple.common.utils.MailSender;
import com.goforit.firstapple.user.manager.UserManager;
import com.goforit.firstapple.user.model.User;
import com.goforit.firstapple.user.service.UserService;

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
    public FacadeResult<User> register(User user) {

        // send mail
        User registerUser=userManager.register(user);

        // send email
        userManager.sendUserRegisterMail(user.getUsername(),user.getEmail());

        return FacadeResult.success(registerUser);
    }

    @Override
    public String mailRegisterOver(String username, String token) {

        UserOperationToken userOperationToken = userManager.getLatest(username,
            UserOperationType.USER_REGISTER_OPERATION);

        if (StringUtils.equals(token, userOperationToken.getToken())) {
            userManager.registerOver(username,true);
            return "register_success";
        }else {
            userManager.registerOver(username,false);
            return "register_failed";

        }

    }


}
