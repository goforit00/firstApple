package web.controller;

import logger.CommonLogger;
import logger.LoggerGetter;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import result.ReturnResult;
import web.model.User;
import biz.UserLogin;
import common.StringUtil;
import enums.ResultEnum;

/**
 * 
 * @author junqing.fjq
 * @version $Id: LoginController.java, v 0.1 2014年9月4日 下午9:33:22 junqing.fjq Exp $
 */
@Controller
public class LoginController {
    private CommonLogger logger = LoggerGetter.getLogger(LoginController.class);
    

    @Autowired
    private UserLogin    userLogin;
    @RequestMapping("/loginResult")
    public String doUserLogin(String username, String password, Model model) {
        if (StringUtil.isBlank(username) || StringUtil.isBlank(password)) {
            return "login_fail";
        }

        model.addAttribute("username", username);
        ReturnResult<User> result = userLogin.doUserLogin(username, password);
        if (result != null) {
            User user = result.getResult();
            if (user != null
                && StringUtil.equals(result.getResultEnum().getValue(),
                    ResultEnum.OPERATE_SUCCESS.getValue())) {
                logger.info("userId=" + user.getUserId() + " login success");
                return "login_suc";
            }
        }

        model.addAttribute("error", result.getErrorDetail());
        return "login_fail";
    }

    /**
     * Getter method for property <tt>userLogin</tt>.
     * 
     * @return property value of userLogin
     */
    public UserLogin getUserLogin() {
        return userLogin;
    }

    /**
     * Setter method for property <tt>userLogin</tt>.
     * 
     * @param userLogin value to be assigned to property userLogin
     */
    public void setUserLogin(UserLogin userLogin) {
        this.userLogin = userLogin;
    }
    
    @RequestMapping("/login")
    public String doLogin() {
        return "login";
    }

}
