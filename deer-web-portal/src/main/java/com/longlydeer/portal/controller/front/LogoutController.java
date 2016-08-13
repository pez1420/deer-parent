package com.longlydeer.portal.controller.front;


import com.longlydeer.deer.common.web.utils.CookieUtils;
import com.longlydeer.deer.portal.entity.Member;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * 注销用户,删除session对应的属性
 * 删除cookie
 */
@Controller("frontLogoutController")
public class LogoutController extends BaseController {

    @RequestMapping(value={"/logout"}, method={RequestMethod.GET})
    public String execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        session.removeAttribute(Member.PRINCIPAL_ATTRIBUTE_NAME);
        CookieUtils.removeCookie(request,response,"username");
        return "redirect:/";
    }
}
