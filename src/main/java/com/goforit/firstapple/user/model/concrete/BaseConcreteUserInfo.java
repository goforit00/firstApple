package com.goforit.firstapple.user.model.concrete;

import com.goforit.firstapple.user.model.User;
import com.goforit.firstapple.user.model.enums.UserType;

import java.util.Date;

/**
 * Created by junqingfjq on 16/6/27.
 */
abstract public class BaseConcreteUserInfo {

    private long id;

    private User user;

    private Date latestLoginTime;

    private Date modifiedTime;

    abstract public UserType getUserType();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getLatestLoginTime() {
        return latestLoginTime;
    }

    public void setLatestLoginTime(Date latestLoginTime) {
        this.latestLoginTime = latestLoginTime;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }
}
