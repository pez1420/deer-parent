package com.longlydeer.deer.servlet;


import com.octo.captcha.service.CaptchaServiceException;
import org.apache.log4j.Logger;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;


//@WebServlet(name = "ImageCaptchaServlet")
public class ImageCaptchaServlet extends HttpServlet {
    private static final Logger logger = Logger.getLogger(ImageCaptchaServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Cache-Control", "no-store");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");

        logger.debug("tring to get image captcha service");

        ServletOutputStream servletOutputStream = null;
        try {
            servletOutputStream = response.getOutputStream();
            //借助于HttpSession ID存储Captcha ID，开发者也可以借助于其他惟一值
            BufferedImage bufferedImage = SampleImageCaptchaService.getInstance()
                    .getImageChallengeForID(request.getSession().getId());
            logger.debug("#session id is " + request.getSession().getId());
            logger.debug("tring to output buffered image to servlet output stream");
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
    }

}
