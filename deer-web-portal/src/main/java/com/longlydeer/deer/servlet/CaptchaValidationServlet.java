package com.longlydeer.deer.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CaptchaValidationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String captcha = request.getParameter("captcha");
        boolean validate = SampleImageCaptchaService.getInstance()
                .validateResponseForID(request.getSession().getId(), captcha);

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = null;
        try {
            out = response.getWriter();
            if (validate)
                out.println("<html><body>验证成功!</body></html>");
            else
                out.println("<html><body>验证失败!</body></html>");
        }catch(IOException e) {

        } finally {
            if (out != null)
                out.close();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
