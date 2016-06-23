package com.goforit.firstapple.user.model;

import com.goforit.firstapple.user.model.enums.UserOperationType;

import java.util.Date;

/**
 * Created by junqingfjq on 16/6/23.
 */
public class UserOperationToken {

    private String id;

    private String username;

    private String token;

    private UserOperationType type;

    private Date createdTime;

    /**
     * 过期时间
     */
    private Date expirationTime;

    public static UserOperationToken build(String username,String token,UserOperationType type,Date expirationTime){
        UserOperationToken operationToken=new UserOperationToken();
        operationToken.setUsername(username);
        operationToken.setToken(token);
        operationToken.setType(type);
        operationToken.setCreatedTime(new Date());
        operationToken.setExpirationTime(expirationTime);

        return operationToken;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UserOperationType getType() {
        return type;
    }

    public void setType(UserOperationType type) {
        this.type = type;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(Date expirationTime) {
        this.expirationTime = expirationTime;
    }
}
