package com.dreamer.education.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 表映射注解
 * @since 2013-10-21 下午5:05:41
 * @author broken_xie
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface TableMapper {
    
    public String name() default "";
}
