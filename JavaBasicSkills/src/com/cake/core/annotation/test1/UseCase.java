package com.cake.core.annotation.test1;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)//定义注解使用位置(FEILD,METHOD..)
@Retention(RetentionPolicy.RUNTIME)//注解使用级别(SOURCE,CLASS,RUNTIME)
public @interface UseCase {
	public int id();
	public String description() default "no description";
}
