package com.longlydeer.deer.common.annotation;

import java.lang.annotation.*;

/**
 * 用于解释实体做什么用
 * @author  pez1420@163.com
 * @version 1.0
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface EntityInfo {
    String value() default "";
}
