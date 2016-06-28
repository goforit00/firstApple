package com.goforit.firstapple.user.model.concrete;

import com.goforit.firstapple.user.model.enums.UserType;

/**
 * Created by junqingfjq on 16/6/27.
 */
public class Administrator extends BaseConcreteUserInfo{

    private long authRoleId;

    @Override
    public UserType getUserType() {
        return UserType.MANAGER;
    }

    public long getAuthRoleId() {
        return authRoleId;
    }

    public void setAuthRoleId(long authRoleId) {
        this.authRoleId = authRoleId;
    }
}
