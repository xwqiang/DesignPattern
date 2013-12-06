package com.designPattern.annotation;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.List;

import javax.xml.bind.ValidationException;

public class UniqueValidator extends Validator{

  @Override
  protected void validateMethod(Object obj, Method method, Annotation annotation) {
    Unique unique = (Unique) annotation;
    try {
      Method scopeMethod = obj.getClass().getMethod("get" + 
          unique.scope().getSimpleName());
      Object scopeObj = scopeMethod.invoke(obj, new Object[0]);
      
      Method collectionMethod = scopeObj.getClass().getMethod(
          "get" + obj.getClass().getSimpleName() + "s");
      List collection = (List)collectionMethod.invoke(scopeObj, new Object[0]);
      Object returnValue = method.invoke(obj, new Object[0]);
      for(Object otherObj: collection){
        Object otherReturnValue = otherObj.getClass().
            getMethod(method.getName()).invoke(otherObj, new Object[0]);
        if (!otherObj.equals(obj) && otherReturnValue.equals(returnValue))
          throw new ValidationException(method.getName() + " on " + 
            obj.getClass().getSimpleName() + " should be unique but is not since");
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
      throw new ValidationException(e.getMessage());
    }
  }

  @Override
  protected Class getAnnotationType() {
    return Unique.class;
  }
}