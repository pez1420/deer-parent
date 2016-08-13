package com.longlydeer.deer.portal.service.impl;

import com.longlydeer.deer.portal.service.CaptchaService;
import com.octo.captcha.service.CaptchaServiceException;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.awt.image.BufferedImage;


@Service("captchaServiceImpl")
public class CaptchaServiceImpl implements CaptchaService {
    @Override
    public BufferedImage buildCaptchaImage(String captchaId) {
        return null;
    }

    @Override
    public boolean isValidate(String captchaId, String captcha) {
        return false;
    }

/*    private static final Logger logger = Logger.getLogger(CaptchaServiceImpl.class);

    @Resource(name = "imageCaptchaService")
    private com.octo.captcha.service.CaptchaService imageCaptchaService;

    @Override
    public BufferedImage buildCaptchaImage(String captchaId) {
        return (BufferedImage) this.imageCaptchaService.getChallengeForID(captchaId);
    }

    @Override
    public boolean isValidate(String captchaId, String captcha) {
        if (StringUtils.isNotEmpty(captchaId) && StringUtils.isNotEmpty(captcha)) {
            logger.debug(String.format("captchaId={%s} captcha={%s}", captchaId, captcha));
            try {
                return imageCaptchaService.validateResponseForID(captchaId, captcha.toLowerCase()).booleanValue();
            } catch (CaptchaServiceException e) {
                logger.debug("验证码发生异常");
                logger.error(e.getMessage(), e);
                return false;
            }
        }
        return false;
    }*/
}
