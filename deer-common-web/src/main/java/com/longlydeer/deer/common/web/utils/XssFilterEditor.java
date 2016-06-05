package com.longlydeer.deer.common.web.utils;


import org.jsoup.safety.Whitelist;

import java.beans.PropertyEditorSupport;

/**
 * 过滤页面中可能存在的XSS攻击
 *
 * @author pez1420@163.com
 * @version 1.0
 */
public class XssFilterEditor extends PropertyEditorSupport{

    private boolean trim;
    private boolean emptyAsNull;
    private Whitelist whitelist = Whitelist.none();

    public XssFilterEditor(boolean trim, boolean emptyAsNull) {
        this(trim, emptyAsNull, null);
    }

    public XssFilterEditor(boolean trim, boolean emptyAsNull, Whitelist whitelist) {
        this.trim = trim;
        this.emptyAsNull = emptyAsNull;
        if (whitelist != null)
            this.whitelist = whitelist;
    }

    @Override
    public String getAsText() {
        return super.getAsText();
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        super.setAsText(text);
    }
}
