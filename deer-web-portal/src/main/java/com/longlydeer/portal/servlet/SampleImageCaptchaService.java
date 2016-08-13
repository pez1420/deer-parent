package com.longlydeer.portal.servlet;


import com.octo.captcha.service.captchastore.FastHashMapCaptchaStore;
import com.octo.captcha.service.image.DefaultManageableImageCaptchaService;
import com.octo.captcha.service.image.ImageCaptchaService;

/**
 * 验证码Service实例
 *
 * @author pez1420@163.com
 * @version 1.0
 */
public class SampleImageCaptchaService {
    private static volatile ImageCaptchaService instance;

    private SampleImageCaptchaService(){}

    public static ImageCaptchaService getInstance() {
        if (instance == null) {
            synchronized (SampleImageCaptchaService.class) {
                if (instance == null)
                    instance = new DefaultManageableImageCaptchaService(new FastHashMapCaptchaStore(),
                            new SampleListImageCaptchaEngine(),
                            180, 100000, 75000);
            }
        }

        return instance;
    }

}