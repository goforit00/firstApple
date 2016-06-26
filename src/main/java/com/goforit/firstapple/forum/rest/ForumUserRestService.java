package com.goforit.firstapple.forum.rest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
* Created by junqingfjq on 16/6/22.
*/

@Controller
@RequestMapping("/forum")
public class ForumUserRestService {


    @RequestMapping(value="/user",method = RequestMethod.GET)
    public String userLogin(ModelMap model){

        model.addAttribute("message", "user-rest");
        return "hello";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String test(ModelMap model){

        model.addAttribute("message", "test");
        return "hello";
    }


}
