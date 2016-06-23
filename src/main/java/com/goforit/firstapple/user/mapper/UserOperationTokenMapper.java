package com.goforit.firstapple.user.mapper;

import com.goforit.firstapple.user.model.UserOperationToken;
import com.goforit.firstapple.user.model.enums.UserOperationType;

/**
 * Created by junqingfjq on 16/6/23.
 */
public interface UserOperationTokenMapper {

    UserOperationToken getLatest(String username,UserOperationType type);

    void create(UserOperationToken userOperationToken);

    UserOperationToken get(String id);

}
