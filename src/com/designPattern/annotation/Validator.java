package com.designPattern.annotation;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import javax.xml.bind.ValidationException;


public abstract class Validator {

    @SuppressWarnings("unchecked")
	public void validate(Object obj) throws ValidationException {
        Class clss = obj.getClass();
        for(Method method : clss.getMethods())
            if (method.isAnnotationPresent(getAnnotationType()))
                validateMethod(obj, method, method.getAnnotation(getAnnotationType()));
    }

    protected abstract Class getAnnotationType();
    protected abstract void validateMethod(
        Object obj, Method method, Annotation annotation);
}