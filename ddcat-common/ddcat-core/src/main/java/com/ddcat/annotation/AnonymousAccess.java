package com.ddcat.annotation;

import java.lang.annotation.*;

/**
 * 用于标记匿名访问方法
 *
 * @author dd-cat
 */
@Documented
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface AnonymousAccess {
}
