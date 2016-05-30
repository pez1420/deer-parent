package com.longlydeer.deer.controller.frontend;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import java.util.Date;
import java.util.Set;

/**
 * Created by Administrator on 2016/5/5.
 */
public class BaseController {

    @InitBinder
    protected void dataBinder(WebDataBinder webDataBinder) {
        // 一个用于修剪(trim)String类型的属性编辑器，具有将一个空字符串转化为null值的选项。
        // 默认没有注册,必须由用户在需要的时候自行注册
        webDataBinder.registerCustomEditor(String.class,
                new StringTrimmerEditor(true));
        //webDataBinder.registerCustomEditor(Date.class, new DateEditor(true));
    }


/*    //验证参考资料 http://yingzhuo.iteye.com/blog/1455438
    protected boolean validate(Object object, Class<?>[] clazzes) {
        Set set = this.validator.validate(object, clazzes);
        if (set.isEmpty())
            return true;
        RequestAttributes requestAttributes = RequestContextHolder
                .currentRequestAttributes();
        requestAttributes
                .setAttribute("constraintViolations", set, 0);
        return false;
    }

    protected boolean validate(Class<?> clazz, String paramString,
                               Object paramObject, Class<?>[] clazzes) {
        Set set = this.validator.validateValue(clazz, paramString,
                paramObject, clazzes);
        if (set.isEmpty())
            return true;
        RequestAttributes localRequestAttributes = RequestContextHolder
                .currentRequestAttributes();
        localRequestAttributes
                .setAttribute("constraintViolations", set, 0);
        return false;
    }*/


}
