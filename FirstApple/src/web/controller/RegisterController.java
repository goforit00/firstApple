package web.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logger.CommonLogger;
import logger.LoggerGetter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import result.ReturnResult;
import web.model.User;
import biz.UserRegister;
import common.StringUtil;
import enums.ResultEnum;

/**
 * 
 * @author junqing.fjq
 * @version $Id: RegisterController.java, v 0.1 2014年9月4日 下午9:33:14 junqing.fjq Exp $
 */
@Controller
public class RegisterController {
    private CommonLogger logger = LoggerGetter.getLogger(RegisterController.class);
    @Autowired
    private UserRegister userRegister;

    @RequestMapping("/registerResult")
    public String doUserRegister(String username, String password, String sex, Model model){
        if (StringUtil.isBlank(username) || StringUtil.isBlank(password)) {
            model.addAttribute("error", "argume can't be null");
            return "register_fail";
        }

        System.err.println(username);

       // username = new String(username.getBytes("UTF-8"),"GBK");

        logger.info("user register,userName=" + username + " sex=" + sex);
        User user = new User();
        user.setName(username);
        user.setPassword(password);
        user.setSex(sex);

        System.err.println(username);
        ReturnResult<User> result = userRegister.doUserRegister(user);
        if (StringUtil.equals(result.getResultEnum().getValue(),
            ResultEnum.OPERATE_SUCCESS.getValue())) {
            User user_registed = result.getResult();
            model.addAttribute("username", user.getName());
            logger.info("user register success userId=" + user_registed.getUserId() + " userName="
                        + user_registed.getName());
            return "register_suc";
        }

        logger.info("user regiger fail,userName same. userName="+username);
        model.addAttribute("error", result.getErrorDetail());
        model.addAttribute("username", username);
        return "register_fail";
    }

    @RequestMapping("/register")
    public String doRegister() {
        return "register";
    }
}
