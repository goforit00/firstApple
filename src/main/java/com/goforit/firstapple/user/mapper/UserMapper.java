package com.goforit.firstapple.user.mapper;

import com.goforit.firstapple.user.model.User;

/**
 * Created by junqingfjq on 16/6/23.
 */
public interface UserMapper {

    void create(User user);

    void deleteByUsername(String username);

    User update(User user);

    User get(String id);

    User findByUserName(String username);

    User findByPhone(String phone);

    User findByEmail(String email);

    User checkUserLogin(User user);

}
