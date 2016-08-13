package com.longlydeer.deer.portal.service;

import java.awt.image.BufferedImage;


public interface CaptchaService {

    /**
     * 构建验证码图片
     *
     * @param captchaId
     * @return
     */
    BufferedImage buildCaptchaImage(String captchaId);

    /**
     * 验证用户输入的验证码与页面显示的验证码是否一致
     *
     * @param captchaId 生成的验证码
     * @param captcha 用户输入的验证码
     * @return
     */
    boolean isValidate(String captchaId, String captcha);
}
