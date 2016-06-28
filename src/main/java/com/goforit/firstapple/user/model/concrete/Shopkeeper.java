package com.goforit.firstapple.user.model.concrete;

import com.goforit.firstapple.user.model.enums.UserType;

/**
 * Created by junqingfjq on 16/6/27.
 */
public class Shopkeeper extends BaseConcreteUserInfo{


    @Override
    public UserType getUserType() {
        return UserType.SHOPKEEPER;
    }
}
