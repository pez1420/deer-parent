package com.longlydeer.deer.common.web.interceptors;

import com.longlydeer.deer.common.web.utils.CookieUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;


/**
 * CSRF攻击防御SpringMVC拦截器
 *
 * @author pez1420@163.com
 * @version 1.0
 */
public class CsrfTokenInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws IOException {
        // 从cookie中读取token
        String token = CookieUtils.getCookie(request, "token");
        //csrf一般针对增删改操作，读操作对于攻击者基本没有什么意义，所以开发者在编写程序时需要符合HTTP规范
        //get用于获取数据   post用于修改数据
        //若http请求方式为POST方式
        if (request.getMethod().equalsIgnoreCase("POST")) {
            String requestType = request.getHeader("X-Requested-With");
            // ajax POST 请求
            if (requestType != null && requestType.equalsIgnoreCase("XMLHttpRequest")) {
                if (token != null && token.equals(request.getHeader("token")))
                    return true;
                response.addHeader("tokenStatus", "accessDenied");
            } else if (token != null && token.equals(request.getParameter("token"))) {// 普通表单POST方法
                return true;
            }

            if (token == null) {
                token = UUID.randomUUID().toString();
                CookieUtils.addCookie(request, response, "token", token);
            }
            //SC_FORBIDDEN，状态码是403，表示服务器明白客户的请求，但拒绝响应
            response.sendError(403, "Bad or missing token!");
            return false;
        }


        if (token == null) {
            token = UUID.randomUUID().toString();
            CookieUtils.addCookie(request, response, "token", token);
        }

        //request只有两个页面之间的作用域,不能再传给第3个页面了
        //request只能在一次页面传递之间保存数据，超过就会丢失
        request.setAttribute("token", token);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }
}
