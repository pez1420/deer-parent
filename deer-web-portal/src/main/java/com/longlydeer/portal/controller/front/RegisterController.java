package com.longlydeer.portal.controller.front;

import com.longlydeer.deer.common.entity.BaseEntity;
import com.longlydeer.deer.common.web.shiro.Principal;
import com.longlydeer.deer.common.web.utils.CookieUtils;
import com.longlydeer.deer.common.web.utils.Message;
import com.longlydeer.deer.portal.entity.Children;
import com.longlydeer.deer.portal.entity.Member;
import com.longlydeer.deer.portal.service.CaptchaService;
import com.longlydeer.deer.portal.service.MemberService;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.*;

@Controller("frontRegisterController")
@RequestMapping({"/register"})
public class RegisterController extends BaseController {
    private static final Logger logger = Logger.getLogger(RegisterController.class);

    @Resource(name = "captchaServiceImpl")
    private CaptchaService captchaService;

    @Resource(name = "memberServiceImpl")
    private MemberService memberService;

    /**
     * 用于显示注册首页并向页面传递随机生成的captchaId.<br/>
     * {@link com.longlydeer.portal.controller.front.SharingController#captcha}
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public String index(String username, String child, HttpServletRequest request, ModelMap model) {
        try {
            if (child != null)
                child = URLDecoder.decode(child, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            logger.warn("#child 解码错误!", e);
        }
        String captchaId = UUID.randomUUID().toString();
        model.addAttribute("captchaId", captchaId);
        //从页面申请注册跳转时保存的参数
        model.addAttribute("username", username);
        model.addAttribute("child", child);
        return "/front/register/index";
    }

    /**
     * 会员申请注册,需要验证码验证
     *
     * @param captchaId
     * @param captcha
     * @param username
     * @param recommender
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/apply", method = {RequestMethod.POST})
    @ResponseBody
    public Message apply(/*String captchaId,*/ String captcha, String username,
                         String recommender, String child,
                         HttpServletRequest request, HttpServletResponse response, HttpSession session) {

        String password = request.getParameter("password");

        if (!validateValue(Member.class, "username", username, new Class[]{BaseEntity.Save.class})
                || !validateValue(Member.class, "password", password, new Class[]{BaseEntity.Save.class}))
            return Message.error("front.common.invalid", new Object[0]);

        //if (!captchaService.isValidate(captchaId, captcha))
        //    return Message.error("front.captcha.invalid", new Object[0]);

        String code = (String)request.getSession().getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
        if (captcha == null || !captcha.equals(code))
            return Message.error("front.captcha.invalid", new Object[0]);

        if (this.memberService.usernameExists(username))
            return Message.error("front.login.existAccount", new Object[0]);

        Member member = new Member();
        member.setUsername(username);
        member.setPhone(null);
        member.setPassword(DigestUtils.md5Hex(password));
        member.setIsEnabled(Boolean.valueOf(true));
        member.setIsLocked(Boolean.valueOf(false));
        member.setLockedDate(null);
        member.setLoginDate(new Date());
        member.setLoginFailureCount(Integer.valueOf(0));
        member.setLoginIp(request.getRemoteHost());
        member.setRegisterIp(request.getRemoteHost());

        if (StringUtils.isNotBlank(recommender))
            member.setRecommender(recommender);

        if (StringUtils.isNotBlank(child)) {
            Children children = new Children();
            children.setChineseName(child.trim());
            memberService.saveMember(member, children);
        } else {
            memberService.saveMember(member);
        }


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

        return Message.success("front.register.success", new Object[0]);
    }
}
