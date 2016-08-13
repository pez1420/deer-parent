package com.longlydeer.portal.controller.front;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * 临时首页控制器,以后首页可以采用页面静态化技术
 *
 * @author pez1420@163.com
 * @version 1.0
 */
@Controller("frontIndexController")
@RequestMapping({"/index"})
public class IndexController extends  BaseController{
    private static final Logger logger = Logger.getLogger(IndexController.class);

    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "/front/index";
    }

    @RequestMapping(value = { "/apply" }, method = RequestMethod.GET)
    public String apply(String child, String mobile, RedirectAttributes redirectAttributes) {
        redirectAttributes.addAttribute("child", child);
        redirectAttributes.addAttribute("username", mobile);
        return "redirect:/register.jhtml";
    }
}
