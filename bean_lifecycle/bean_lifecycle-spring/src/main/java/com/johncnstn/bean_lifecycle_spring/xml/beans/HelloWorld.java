package com.johncnstn.bean_lifecycle_spring.xml.beans;

public class HelloWorld {

    public void init() {
        System.out.println("Bean initialized using XML!");
    }

    public void destroy() {
        System.out.println("Bean destroyed using XML!");
    }

}
