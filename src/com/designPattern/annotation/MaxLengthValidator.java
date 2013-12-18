package com.designPattern.annotation;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import javax.xml.bind.ValidationException;

public class MaxLengthValidator extends Validator {

    protected void validateMethod(Object obj, Method method, Annotation annotation) {
        try {
            if (method.getName().startsWith("get")) {
                MaxLength length = (MaxLength)annotation;
                String value = (String)method.invoke(obj, new Object[0]);
                if ((value != null) && (length.length() < value.length())) {
                    String string = method.getName() + " is too long." + 
                        "Its length is " + value.length() + 
                        " but should be no longer than " + length.length();
                    throw new ValidationException(string);
                }
            }
        } catch (Exception e) {
//            throw new ValidationException(e.getMessage());

        }
    }

    @Override
    protected Class getAnnotationType() {
        return MaxLength.class;
    }
}