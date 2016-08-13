package com.longlydeer.deer.common.web.utils;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.util.Assert;
import org.springframework.web.servlet.LocaleResolver;

import java.util.Locale;

/**
 * Created by Administrator on 2016/6/6.
 */
public final class SpringContextUtils implements DisposableBean, ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void destroy() throws Exception {
        applicationContext = null;
    }

    @Override
    public void setApplicationContext(ApplicationContext paramApplicationContext) throws BeansException {
        applicationContext = paramApplicationContext;
    }

    public static Object getBean(String name) {
        Assert.hasText(name);
        return applicationContext.getBean(name);
    }

    public static <T> T getBean(String name, Class<T> requiredType) {
        Assert.hasText(name);
        return applicationContext.getBean(name, requiredType);
    }

    /**语言国际化支持
     *
     * @param code
     * @param args
     * @return
     */
    public static String getMessage(String code, Object... args) {
        LocaleResolver localeResolver = (LocaleResolver) getBean("localeResolver", LocaleResolver.class);
        Locale localLocale = localeResolver.resolveLocale(null);
        return applicationContext.getMessage(code, args, localLocale);
    }
}
