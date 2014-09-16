package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {

    @RequestMapping("/welcome.htm")
    public String doWelcome()
    {
        return "welcome_bak";
    }
}
