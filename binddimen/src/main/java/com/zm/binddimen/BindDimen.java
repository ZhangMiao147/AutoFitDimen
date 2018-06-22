package com.zm.binddimen;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Author: lhy
 * Date: 2018/6/21
 */
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.TYPE)
public @interface BindDimen {
    String normal();
    String[] dimenFit();
}
