package com.longlydeer.deer.common.web.config;

import java.io.Serializable;

/**
 *
 * @author pez1420@163.com
 * @version 1.0
 */
public class Setting implements Serializable{

    private String cookiePath = "/";

    private String cookieDomain = "";

    public String getCookiePath() {
        return cookiePath;
    }

    public void setCookiePath(String cookiePath) {
        this.cookiePath = cookiePath;
    }

    public String getCookieDomain() {
        return cookieDomain;
    }

    public void setCookieDomain(String cookieDomain) {
        this.cookieDomain = cookieDomain;
    }
}
