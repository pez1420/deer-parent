package com.longlydeer.deer.portal.service;

import java.awt.image.BufferedImage;

/**
 * Created by Administrator on 2016/6/5.
 */
public interface CaptchaService {

    BufferedImage buildCaptchaImage(String captchaId);
}
