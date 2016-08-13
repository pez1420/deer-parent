package com.longlydeer.portal.controller.front;

import com.longlydeer.deer.common.web.shiro.Principal;
import com.longlydeer.deer.common.web.utils.CookieUtils;
import com.longlydeer.deer.common.web.utils.Message;
import com.longlydeer.deer.portal.entity.Member;
import com.longlydeer.deer.portal.service.CaptchaService;
import com.longlydeer.deer.portal.service.MemberService;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * 用户登录控制器
 *
 * @author pez1420@163.com
 */
@Controller("frontLoginController")
@RequestMapping("/login")
public class LoginController extends BaseController{

    @Resource
    private CaptchaService captchaService;

    @Resource
    private MemberService memberService;

    @RequestMapping(method = RequestMethod.GET)
    public String index(ModelMap map) {
        //map.addAttribute("redirectUrl", "/index.jhtml");
        //map.addAttribute("captchaId", UUID.randomUUID().toString());
        return "front/login/index";
    }

    @RequestMapping(value = { "/submit" }, method = { RequestMethod.POST })
    @ResponseBody
    public Message submit(String captchaId, String captcha, String username,
                          HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        String password = request.getParameter("password");
/*        //验证码
        if (!captchaService.isValidate(captchaId, captcha)) {
            return Message.error("front.captcha.invalid", new Object[0]);
        }
*/
        //非空
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password))
            return Message.error("front.common.invalid", new Object[0]);

        Member member = this.memberService.findByUsername(username);
        if (member == null)
            return Message.error("front.login.unknownAccount", new Object[0]);
        if (!member.getIsEnabled().booleanValue())
            return Message.error("front.login.disabledAccount", new Object[0]);

        //是否已经锁住
        if (member.getIsLocked().booleanValue()) {
            Date lockedDate = member.getLockedDate();
            Date unlockedDate = DateUtils.addMinutes(lockedDate, 3);
            //已经解锁
            if (new Date().after(unlockedDate)) {
                member.setLoginFailureCount(Integer.valueOf(0));
                member.setIsLocked(Boolean.valueOf(false));
                member.setLockedDate(null);
                this.memberService.update(member);
            } else {
                return Message.error("front.login.lockedAccount", new Object[0]);
            }
        }

        //密码验证
        if (!DigestUtils.md5Hex(password).equals(member.getPassword())) {
            int i = member.getLoginFailureCount().intValue() + 1;
            if (i >= 3) {
                member.setIsLocked(Boolean.valueOf(true));
                member.setLockedDate(new Date());
            }
            member.setLoginFailureCount(Integer.valueOf(i));
            this.memberService.update(member);
            return Message.error("front.login.incorrectCredentials", new Object[0]);
        }

        member.setLoginIp(request.getRemoteAddr());
        member.setLoginDate(new Date());
        member.setLoginFailureCount(Integer.valueOf(0));
        this.memberService.update(member);

        HashMap<String, Object> sessionMap = new HashMap<String, Object>();

        for (Enumeration e = session.getAttributeNames(); e.hasMoreElements();) {
            String key = (String) e.nextElement();
            sessionMap.put(key, session.getAttribute(key));
        }

        session.invalidate();

        session = request.getSession();
        for (Map.Entry<String, Object> entry : sessionMap.entrySet()) {
            session.setAttribute(entry.getKey(), entry.getValue());
        }
        session.setAttribute(Member.PRINCIPAL_ATTRIBUTE_NAME,
                new Principal(member.getId(), member.getUsername()));
        //客户端响应cookie
        CookieUtils.addCookie(request, response, "username", member.getUsername());

        return Message.success("front.login.loginSuccess", new Object[0]);
    }
}
