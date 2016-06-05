package com.longlydeer.deer.common.web.utils;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.util.Assert;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * 服务器端Cookie操作相关功能
 *
 * @author pez1420@163.com
 * @version 1.0
 */
public final class CookieUtils {

    public static final Logger logger = Logger.getLogger(CookieUtils.class);

    public static final String COOKIE_DEFAULT_ENCODING = "UTF-8";

    /**
     * 向客户端输出cookie
     * @param request 请求
     * @param response 响应
     * @param name cookie名称
     * @param value cookie值
     * @param maxAge Cookie的有效期,单位为秒(Second)
     * @param path 路径
     * @param domain 域
     * @param secure cookie是否采用加密的传输方式
     */
    public static void addCookie(HttpServletRequest request, HttpServletResponse response,
                                 String name, String value, Integer maxAge,
                                 String path, String domain, Boolean secure) {
        Assert.notNull(request);
        Assert.notNull(response);
        Assert.hasText(name);

        try {
            name = URLEncoder.encode(name, COOKIE_DEFAULT_ENCODING);
            value = URLEncoder.encode(value, COOKIE_DEFAULT_ENCODING);
            Cookie cookie = new Cookie(name, value);
            if (maxAge != null)
                cookie.setMaxAge(maxAge); //默认值为-1
            if (StringUtils.isNotEmpty(path))
                cookie.setPath(path);
            if (StringUtils.isNotEmpty(domain))
                cookie.setDomain(domain);
            if (secure != null)
                cookie.setSecure(secure);
            response.addCookie(cookie);
        } catch (UnsupportedEncodingException e) {
            logger.error("#" + name + "=" + value + " failed to be encoded!");
        }

    }

    /**
     *
     * @param request
     * @param response
     * @param name
     * @param value
     * @param maxAge
     */
    public static void addCookie(HttpServletRequest request, HttpServletResponse response,
                                 String name, String value, Integer maxAge) {
        addCookie(request, response, name, value, maxAge, "/", "", null);
    }

    /**
     *
     * @param request
     * @param response
     * @param name
     * @param value
     */
    public static void addCookie(HttpServletRequest request, HttpServletResponse response,
                                 String name, String value) {
        addCookie(request, response, name, value, null);
    }

    /**
     * 删除cookie,将cookie的maxAge设置为0
     *
     * @param request   请求
     * @param response  响应
     * @param name  cookie名称
     * @param path  路径
     * @param domain 域名
     */
    public static void removeCookie(HttpServletRequest request, HttpServletResponse response,
                                      String name, String path, String domain) {
        Assert.notNull(request);
        Assert.notNull(response);
        Assert.hasText(name);

        try {
            name = URLEncoder.encode(name, COOKIE_DEFAULT_ENCODING);
            Cookie cookie = new Cookie(name, null);
            if (StringUtils.isNotEmpty(path))
                cookie.setPath(path);
            if (StringUtils.isNotEmpty(domain))
                cookie.setDomain(domain);
            cookie.setMaxAge(0); //设置为0表示删除cookie
            response.addCookie(cookie);
        } catch (UnsupportedEncodingException e) {
            logger.error("cookie " + name + " failed to be deleted!");
        }
    }

    /**
     *
     * @param request
     * @param response
     * @param name
     */
    public static void removeCookie(HttpServletRequest request, HttpServletResponse response,
                                    String name) {
        removeCookie(request, response, name, "/", "");
    }


    /**
     * 根据cookie名称返回对应的值
     *
     * @param request 请求
     * @param name  cookie名称
     * @return
     */
    public static String getCookie(HttpServletRequest request, String name) {
        Assert.notNull(request);
        Assert.hasText(name);

        String value = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies)
                try {
                    if (name.equals(URLDecoder.decode(cookie.getName(), COOKIE_DEFAULT_ENCODING))) {
                        value = URLDecoder.decode(cookie.getValue(), COOKIE_DEFAULT_ENCODING);
                        break;
                    }
                } catch (UnsupportedEncodingException e) {
                    logger.error("cookie " + name + " failed to be deocoded!");
                }
        }
        return value;
    }

}
