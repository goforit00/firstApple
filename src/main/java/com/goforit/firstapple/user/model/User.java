package com.goforit.firstapple.user.model;

import com.goforit.firstapple.common.utils.EncryptionUtil;
import com.goforit.firstapple.user.model.enums.UserLoginType;
import com.goforit.firstapple.user.model.enums.UserStatus;

import java.util.Date;

/**
 * Created by junqingfjq on 16/6/23.
 */
public class User {

    private String id;

    private String username;

    private transient String password;

    /**
     * 身份证号码
     */
    private transient String idCardNum;

    private String phone;

    private String email;

    private String age;

    private String sex;

    private String realName;

    private UserStatus status;

    private Date lastLoginTime;

    private Date registerTime;

    private Date modifiedTime;

    public static User buildLoginCheckUser(String userInfo,String password,UserLoginType type){
        User user=new User();
        switch (type){
            case USERNAME:
                user.setUsername(userInfo);
                break;
            case PHONE:
                user.setPhone(userInfo);
                break;
            case EMAIL:
                user.setEmail(userInfo);
                break;
            default:
                user.setUsername(userInfo);
                break;
        }
        user.setPassword(EncryptionUtil.encryptMD5(password));

        return user;
    }

    public User encryptionPassword(){
        this.setPassword(EncryptionUtil.encryptMD5(this.password));
        return this;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdCardNum() {
        return idCardNum;
    }

    public void setIdCardNum(String idCardNum) {
        this.idCardNum = idCardNum;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }
}
