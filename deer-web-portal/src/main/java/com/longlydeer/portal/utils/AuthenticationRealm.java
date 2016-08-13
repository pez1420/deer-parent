package com.longlydeer.portal.utils;


import com.longlydeer.deer.common.web.shiro.CaptchaUsernamePasswordToken;
import com.longlydeer.deer.portal.service.CaptchaService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.pam.UnsupportedTokenException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;


public class AuthenticationRealm extends AuthorizingRealm {

    @Resource
    private CaptchaService captchaService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        CaptchaUsernamePasswordToken captchaToken = (CaptchaUsernamePasswordToken)token;
        String username = captchaToken.getUsername();
        String password = new String(captchaToken.getPassword());
        String captchaId = captchaToken.getCaptchaId();
        String captcha = captchaToken.getCaptcha();

        if (!this.captchaService.isValidate(captchaId,captcha))
            throw new UnsupportedTokenException();

        return null;
    }


}
