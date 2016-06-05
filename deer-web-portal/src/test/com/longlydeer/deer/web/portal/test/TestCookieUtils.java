package com.longlydeer.deer.web.portal.test;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.servlet.http.Cookie;

/**
 * Created by Administrator on 2016/6/2.
 */
public class TestCookieUtils {

    private Cookie cookie;

    @Before
    public void init() {
        cookie = new Cookie("name", "luyoubing");
    }

    @Test
    public void test_cookie_secure() {
        Assert.assertFalse(cookie.getSecure()); //secure = false
        Assert.assertTrue(cookie.getPath() == null); //true
        Assert.assertTrue(cookie.getDomain() == null); //true
    }

    @Test
    public void test_cookie_maxAge() {
        Assert.assertTrue(cookie.getMaxAge() == -1);
    }

}
