package com.longlydeer.deer.controller.frontend;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("frontendLogoutController")
public class LogoutController extends BaseController {

    @RequestMapping(value={"/logout"}, method={RequestMethod.GET})
    public String execute() {

        return "redirect:/";
    }
}
