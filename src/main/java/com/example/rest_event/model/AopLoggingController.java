package com.example.rest_event.model;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

//@Aspect
//@Configuration
public class AopLoggingController {

   // @Pointcut("execution(* com.example.rest_event.controller.MySimpleRestController.getRequest(..))")
    private void selectController(){}

  //  @Before("selectController()")
    public void getInformationBeforeCallingController(){
        System.out.println("Controller invoked!!!");
    }

  //  @After("selectController()")
    public void getInformationAfterCallingController(){
        System.out.println("after Controller invoked!!");
    }
}