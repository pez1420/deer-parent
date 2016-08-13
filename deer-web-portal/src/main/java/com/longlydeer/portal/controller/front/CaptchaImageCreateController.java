package com.longlydeer.portal.controller.front;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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

@Controller("frontCaptchaImageCreateController")
@RequestMapping("/captcha")
public class CaptchaImageCreateController {

    private static final Logger logger = Logger.getLogger(CaptchaImageCreateController.class);

    @Resource
    private Producer captchaProducer;

    @RequestMapping(method = RequestMethod.GET)
    public void captcha(HttpServletRequest request, HttpServletResponse response) {
        //response.setHeader("powered-by", "deerkids.com");
        response.setDateHeader("Expires", 0);
        // Set standard HTTP/1.1 no-cache headers.
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        // Set IE extended HTTP/1.1 no-cache headers (use addHeader).
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        // Set standard HTTP/1.0 no-cache header.
        response.setHeader("Pragma", "no-cache");
        // return a jpeg
        response.setContentType("image/jpeg");

        ServletOutputStream out = null;
        try {
            out = response.getOutputStream();
            // create the text for the image
            String capText = captchaProducer.createText();
            // store the text in the session
            request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);
            // create the image with the text
            BufferedImage bi = captchaProducer.createImage(capText);
            // write the data out
            ImageIO.write(bi, "jpg", out);
            out.flush();
        } catch (IOException e) {
            logger.error("failed to generate image challengefor id!!!", e);
        } finally {
            try {
                if (out != null)
                    out.close();
            } catch (IOException e) {
                logger.error("#failed to close servletOutputStream!");
            }
        }
    }


}
