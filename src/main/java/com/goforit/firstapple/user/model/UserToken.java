package com.goforit.firstapple.user.model;

import com.goforit.firstapple.user.factory.UserOperationTokenHandlerFactory;
import com.goforit.firstapple.user.handlers.UserOperationTokenHandler;
import com.goforit.firstapple.user.model.enums.UserOperationType;

import java.util.Date;

/**
 * Created by junqingfjq on 16/6/24.
 */
public class UserToken {

    private long id;

    private String userId;

    private String token;

    private Date modifiedTime;

    private Date expiredTime;

    public static UserToken buildUserToken(String userId){
        UserToken userToken=new UserToken();

        UserOperationTokenHandler handler=UserOperationTokenHandlerFactory.INSTANCE.getHandler(
                UserOperationType.USER_LOGIN_HEADER_TOKEN);

        userToken.setToken(handler.buildToken(userId));
        userToken.setExpiredTime(handler.getExpiredTime(new Date()));
        userToken.setUserId(userId);

        return userToken;
    }

    public UserToken updateTime(Date currentDate){
        UserOperationTokenHandler handler=UserOperationTokenHandlerFactory.INSTANCE.getHandler(
                UserOperationType.USER_LOGIN_HEADER_TOKEN);

        this.setExpiredTime(handler.getExpiredTime(currentDate));

        return this;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public Date getExpiredTime() {
        return expiredTime;
    }

    public void setExpiredTime(Date expiredTime) {
        this.expiredTime = expiredTime;
    }
}
