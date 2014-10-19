package com.annotation;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
 
public class Test {
 
    @Override
    @OnjInfo(name = "onj", year = "2014", desc = "onjoraclejava")
    public String toString() {
        return "Overriding toString method";
    }
 
   /* @Deprecated
    @OnjInfo(name = "oraclejava")
    public static void oldMethod() {
        System.out.println("old method(oraclejava),사용중지.");
    }
    
    @OnjInfo(name = "onjoraclejava", year="2007")
    public static void newMethod() {
        System.out.println("new method(onjoraclejava),OK.");
    }
 
    @SuppressWarnings({"unchecked", "deprecation" })
    @OnjInfo(name = "onj", year="2200")
    public static void genericsTest() throws FileNotFoundException {
        List l = new ArrayList();
        l.add("oraclejava");
        oldMethod();
    }*/
 
}
