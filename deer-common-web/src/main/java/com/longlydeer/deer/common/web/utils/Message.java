package com.longlydeer.deer.common.web.utils;

import java.io.Serializable;


public class Message implements Serializable {

    private static final long serialVersionUID = -5538595808337644075L;

    public enum Type {
        success, warn, error
    }

    private Type type;
    private String content;

    public Message() {
    }

    public Message(Type type, String content) {
        this.type = type;
        this.content = content;
    }

}
