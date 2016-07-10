package com.goforit.firstapple.forum.rest;

import com.goforit.firstapple.user.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by goforit on 16/7/10.
 */

@Controller
@Path("/")
public class RestfulController {

    @Path("/getUser")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public User getUser(){

        User user=new User();
        user.setAge(110);
        return user;
    }
}
