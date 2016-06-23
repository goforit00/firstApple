package com.goforit.firstapple.user.manager.impl;

import com.goforit.firstapple.common.exception.UserRegisterError;
import com.goforit.firstapple.common.mapper.SystemConfigMapper;
import com.goforit.firstapple.common.model.SystemConfigInfo;
import com.goforit.firstapple.common.service.MailContextGeneratorUtil;
import com.goforit.firstapple.common.utils.MailSender;
import com.goforit.firstapple.common.utils.StringGenerator;
import com.goforit.firstapple.user.factory.UserOperationTokenHandlerFactory;
import com.goforit.firstapple.user.handlers.UserOperationTokenHandler;
import com.goforit.firstapple.user.manager.UserManager;
import com.goforit.firstapple.user.mapper.UserMapper;
import com.goforit.firstapple.user.mapper.UserOperationTokenMapper;
import com.goforit.firstapple.user.model.User;
import com.goforit.firstapple.user.model.UserOperationToken;
import com.goforit.firstapple.user.model.enums.UserOperationType;
import com.goforit.firstapple.user.model.enums.UserStatus;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by junqingfjq on 16/6/23.
 */

@Component
public class UserManagerImpl implements UserManager {

    private static final String SRC_MAIL_KEY="src_mail";
    private static final String REGISTER_MAIL_SUB="register_sub";

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MailSender mailSender;

    @Autowired
    private SystemConfigMapper systemConfigMapper;

    @Autowired
    private UserOperationTokenMapper userOperationTokenMapper;

    @Override
    public User register(User user) throws UserRegisterError{

        final String username=user.getUsername();
        final String email=user.getEmail();
        final String phone=user.getPhone();

        //TODO check param

        User usernameUser=userMapper.findByUserName(username);

        User emailUser=null;
        if(StringUtils.isNotBlank(email)){
            emailUser=userMapper.findByEmail(email);
        }

        User phoneUser=null;
        if(StringUtils.isNotBlank(phone)){
            phoneUser=userMapper.findByPhone(phone);
        }

        if( null!=usernameUser ){
            throw new UserRegisterError("user name has existed");
        }

        if(null!=emailUser){
            throw new UserRegisterError("email has existed");
        }

        if(null!=phoneUser){
            throw new UserRegisterError("phone has existed");
        }

        userMapper.create(user);

        User registeredUser=userMapper.findByUserName(username);

        return registeredUser;
    }

    @Override
    public User registerOver(String username, boolean isSuccessful) {

        if(isSuccessful){
            User registerUser=userMapper.findByUserName(username);
            if(null==registerUser){
                throw new RuntimeException("not find registering User "+username);
            }

            registerUser.setStatus(UserStatus.NORMAL);
            userMapper.update(registerUser);

            return registerUser;
        }else {
            userMapper.deleteByUsername(username);
            return null;
        }

    }

    @Override
    public UserOperationToken generateUserOperationToken(String username,UserOperationType type) {

        UserOperationTokenHandler handler=UserOperationTokenHandlerFactory.INSTANCE.getHandler(type);

        String token= handler.buildToken();

        UserOperationToken userOperationToken=UserOperationToken.build(username, token, type,handler.getExpiredTime());
        userOperationTokenMapper.create(userOperationToken);
        return userOperationToken;
    }

    @Override
    public UserOperationToken getLatest(String username, UserOperationType type) {
        return null;
    }

    @Override
    public boolean sendUserRegisterMail(String username,String userMail) {

        SystemConfigInfo srcMailConfigInfo=systemConfigMapper.get(SRC_MAIL_KEY);

        if(null==srcMailConfigInfo){
            throw new RuntimeException("not find src mail system config.");
        }

        //落库验证token
        UserOperationToken token=this.generateUserOperationToken(username,UserOperationType.USER_REGISTER_OPERATION);

        //生成邮件内容
        String mailContext=MailContextGeneratorUtil.INSTANCE.generatorUserRegisterMail(username,token.getToken());

        //发送邮件
        mailSender.sendMail(userMail,srcMailConfigInfo.getValue(),REGISTER_MAIL_SUB,mailContext);

        return true;
    }
}
