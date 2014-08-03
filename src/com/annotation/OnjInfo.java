package com.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

 
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface OnjInfo{
    String name() default "oraclejava community";
    String year() default "2007";    
    String desc() default "개발자실무교육";
}