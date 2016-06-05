package com.longlydeer.deer.common.annotation;

import java.lang.annotation.*;

/**
 * 用于解释字段做什么用
 * @author  pez1420@163.com
 * @version 1.0
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Meaning {
    String value() default "";
}
