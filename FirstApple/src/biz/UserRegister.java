package biz;

import logger.CommonLogger;
import logger.LoggerGetter;

import org.springframework.beans.factory.annotation.Autowired;

import common.GenerateNumber;
import common.Password;
import common.StringUtil;
import result.ReturnResult;
import web.model.User;
import dao.UserDao;
import enums.ResultEnum;

public class UserRegister {

    /**  */
    private CommonLogger     logger     = LoggerGetter.getLogger(UserRegister.class);
    /**  */
    @Autowired
    private UserDao          userDao;
    /**  */
    private static final int USERID_LEN = 20;

    /**
     * 
     * @param user
     * @return
     */
    public ReturnResult<User> doUserRegister(User user) {
        if (user == null)
            return new ReturnResult<User>(null, ResultEnum.USER_REGISTER_FAILED,
                "user can be null");

        User userInDB = null;

        if (!StringUtil.isBlank(user.getName())) {
            userInDB = userDao.queryUserByUserName(user.getName());
        }
        if (userInDB != null) {
            return new ReturnResult<User>(null, ResultEnum.USER_REGISTER_FAILED_PHONE_SAME,
                "user name has exit");
        }

        String userId = GenerateNumber.generateUniqueNumber(USERID_LEN);
        user.setUserId(userId);
        user.setPassword(Password.generateMD5Password(user.getPassword()));

        userDao.addUser(user);
        //TODO

        logger.info("insert user into db success.userid=" + user.getUserId() + "username="
                    + user.getName());

        return new ReturnResult<User>(user, ResultEnum.OPERATE_SUCCESS, null);
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