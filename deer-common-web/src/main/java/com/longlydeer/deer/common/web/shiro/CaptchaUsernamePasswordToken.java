package com.longlydeer.deer.common.web.shiro;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * 实体凭证信息,增加验证码
 *
 */
public class CaptchaUsernamePasswordToken extends UsernamePasswordToken {

    private String captcha;

    private String captchaId;

    public CaptchaUsernamePasswordToken(String username,
                                        String password,
                                        String captcha,
                                        String captchaId,
                                        boolean rememberMe,
                                        String host) {
        super(username, password, rememberMe, host);
        this.captcha = captcha;
        this.captchaId = captchaId;
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

    public String getCaptchaId() {
        return captchaId;
    }

    public void setCaptchaId(String captchaId) {
        this.captchaId = captchaId;
    }
}
