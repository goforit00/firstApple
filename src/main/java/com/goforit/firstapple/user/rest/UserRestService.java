package com.goforit.firstapple.user.rest;

import com.goforit.firstapple.user.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by junqingfjq on 16/6/23.
 */

@Controller
@RequestMapping(value = "/user")
public class UserRestService {

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String register(User user){
        return null;
    }

    @RequestMapping(value = "/registerToken",method = RequestMethod.PUT)
    public String registerOver(String username,String token){
        return null;
    }
}
