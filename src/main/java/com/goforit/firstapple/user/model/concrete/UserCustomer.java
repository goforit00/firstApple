package com.goforit.firstapple.user.model.concrete;

import com.goforit.firstapple.user.model.enums.UserType;

/**
 * Created by junqingfjq on 16/6/27.
 */
public class UserCustomer extends BaseConcreteUserInfo{

    private long points;

    @Override
    public UserType getUserType() {
        return UserType.NORMAL_USER;
    }

    public long getPoints() {
        return points;
    }

    public void setPoints(long points) {
        this.points = points;
    }
}
