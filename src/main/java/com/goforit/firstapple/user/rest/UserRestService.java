package com.goforit.firstapple.user.rest;

import com.goforit.firstapple.user.model.User;
import com.goforit.firstapple.user.model.UserToken;
import com.goforit.firstapple.user.model.enums.UserLoginType;
import com.goforit.firstapple.user.model.enums.UserType;
import com.goforit.firstapple.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by junqingfjq on 16/6/23.
 */

@Controller
@RequestMapping(value = "/user")
public class UserRestService {

    private static final String AUTHORIZATION_KEY = "Authorization";

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity register(User user) {

        userService.register(user);

        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/registerToken", method = RequestMethod.PUT)
    public ResponseEntity registerOver(String username, String token) {

        UserToken userToken = userService.mailRegisterOver(username, token);

        HttpHeaders headers = new HttpHeaders();
        headers.add(AUTHORIZATION_KEY, userToken.getToken());

        return new ResponseEntity(headers, HttpStatus.OK);
    }

    /**
     * 注意： 需要支持 页面，手机，微信等 登录 方式；
     *       需要支持 普通用户，商家，管理员登录
     *
     * @param userInfo
     * @param password
     * @param loginType
     * @param userType
     * @param request
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity login(@RequestBody String userInfo, @RequestBody String password, String loginType, String userType, HttpServletRequest request) {
        HttpHeaders headers = new HttpHeaders();
        String token = request.getHeader(AUTHORIZATION_KEY);

        UserToken userToken = null;
        User loginUser = userService.verifyToken(token);

        if (null == loginUser) {
            userToken = userService.login(userInfo, password, UserLoginType.valueOf(loginType), UserType.valueOf(userType));
        }

        headers.add(AUTHORIZATION_KEY, userToken.getToken());

        return new ResponseEntity(headers, HttpStatus.OK);
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public void logout(HttpServletRequest request) {
        String token = request.getHeader(AUTHORIZATION_KEY);

        userService.logout(token);
    }


}
