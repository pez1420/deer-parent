package com.longlydeer.deer.controller.front;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("frontLogoutController")
public class LogoutController extends BaseController {

    @RequestMapping(value={"/logout"}, method={RequestMethod.GET})
    public String execute() {

        return "redirect:/";
    }
}
