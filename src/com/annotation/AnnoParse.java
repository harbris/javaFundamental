package com.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
 
public class AnnoParse {
 
    public static void main(String[] args) {
        try {
            for (Method method : AnnoParse.class
                    .getClassLoader()
                    .loadClass(("com.annotation1.Test"))
                    .getMethods()) {
                // checks if MethodInfo annotation is present for the method
                if (method.isAnnotationPresent(OnjInfo.class)) {
                    try {
                        // iterates all the annotations available in the method
                        for (Annotation anno : method.getDeclaredAnnotations()) {
                            System.out.println("Annotation in Method '"
                                    + method + "' : " + anno);
                        }
                        OnjInfo methodAnno = method
                                .getAnnotation(OnjInfo.class);
                        if (methodAnno.year() == "2200") {
                            System.out.println("forever!! oraclejava, onj"+ method);
                        }
 
                    } catch (Throwable ex) {
                        ex.printStackTrace();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
}