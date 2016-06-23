package com.goforit.firstapple.user.handlers;

import com.goforit.firstapple.user.model.enums.UserOperationType;

/**
 * Created by junqingfjq on 16/6/23.
 */
public class UserRegisterOperationTokenHandler extends AbstractUserOperationTokenHandler {
    @Override
    protected int getTokenLen() {
        //字符串长度6
        return 6;
    }

    @Override
    protected int getDuration() {
        //过期时间4个hours
        return 60*60*4;
    }

    @Override
    protected UserOperationType getUserOperationType() {
        return UserOperationType.USER_REGISTER_OPERATION;
    }


}
