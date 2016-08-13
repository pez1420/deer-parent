package com.longlydeer.portal.controller.front;

import com.longlydeer.deer.portal.service.CaptchaService;
import com.octo.captcha.service.CaptchaServiceException;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * 公用控制器,验证码生成
 *
 * @author pez1420@163.com
 * @version 1.0
 */
@Controller("frontSharingController")
@RequestMapping("/sharing")
public class SharingController extends BaseController {
    private static final Logger logger = Logger.getLogger(SharingController.class);

/*    @Resource(name = "captchaServiceImpl")
    private CaptchaService captchaService;

    @RequestMapping(value = "/captcha", method = RequestMethod.GET)
    public void captcha(String captchaId, HttpServletRequest request, HttpServletResponse response) {
        if (StringUtils.isEmpty(captchaId))
            captchaId = request.getSession().getId();

        response.setHeader("powered-by", "deerkids.com");
        response.setHeader("Cache-Control", "no-store");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");

        ServletOutputStream servletOutputStream = null;
        try {
            servletOutputStream = response.getOutputStream();
            BufferedImage bufferedImage = this.captchaService.buildCaptchaImage(captchaId);
            ImageIO.write(bufferedImage, "jpg", servletOutputStream);
            servletOutputStream.flush();
        }catch (CaptchaServiceException e) {
            logger.error("failed to generate image challengefor id!!!");
        } catch (IOException e) {
            logger.error("failed to write captcha iamge to client!!!");
        } finally {
            try {
                if (servletOutputStream != null) {
                    servletOutputStream.close();
                }
            } catch (IOException e) {
                logger.error("#failed to close servletOutputStream!");
            }
        }
    }*/

}
