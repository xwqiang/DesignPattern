package com.designPattern.annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


@Retention(RetentionPolicy.RUNTIME)
public @interface MaxLength {
	int length() default 0;
}