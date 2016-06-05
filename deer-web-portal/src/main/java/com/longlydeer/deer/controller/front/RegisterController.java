package com.longlydeer.deer.controller.front;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller("frontRegisterController")
@RequestMapping({"/register"})
public class RegisterController extends BaseController{
    private static final Logger logger = Logger.getLogger(RegisterController.class);


}
