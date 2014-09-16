package biz;

import logger.CommonLogger;
import logger.LoggerGetter;

import org.springframework.beans.factory.annotation.Autowired;

import common.Password;
import common.StringUtil;
import result.ReturnResult;
import web.model.User;
import dao.UserDao;
import enums.ResultEnum;

public class UserLogin {
    private CommonLogger logger = LoggerGetter.getLogger(UserLogin.class);
    @Autowired
    private UserDao      userDao;

    public ReturnResult<User> doUserLogin(String userName, String password) {
        if (StringUtil.isBlank(userName) || StringUtil.isBlank(password)) {
            return new ReturnResult<User>(null, ResultEnum.USER_LOGIN_FAILED,
                "ÓÃ»§µÇÂ¼Ê§°Ü£¬userName is null or password is null");
        }
        User user = userDao.queryUserByUserName(userName);
        if (user == null) {
            return new ReturnResult<User>(null, ResultEnum.USER_LOGIN_FAILED, "userName" + userName
                                                                    + " not exit");
        }
        if (StringUtil.equals(user.getPassword(), Password.generateMD5Password(password))) {
            return new ReturnResult<User>(user, ResultEnum.OPERATE_SUCCESS, null);
        }

        return new ReturnResult<User>(null, ResultEnum.USER_LOGIN_FAILED, "password not right");
    }

    /**
     * Getter method for property <tt>userDao</tt>.
     * 
     * @return property value of userDao
     */
    public UserDao getUserDao() {
        return userDao;
    }

    /**
     * Setter method for property <tt>userDao</tt>.
     * 
     * @param userDao value to be assigned to property userDao
     */
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

}
