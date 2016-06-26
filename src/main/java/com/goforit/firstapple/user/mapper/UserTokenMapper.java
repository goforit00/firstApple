package com.goforit.firstapple.user.mapper;

import com.goforit.firstapple.user.model.UserToken;

/**
 * Created by junqingfjq on 16/6/24.
 */
public interface UserTokenMapper {

    void create(UserToken userToken);

    void deleteByUserId(String userId);

    UserToken get(String id);

    UserToken findByUserId(String userId);

    UserToken findByToken(String token);

    int updateExpiredTime(UserToken userToken);

}
