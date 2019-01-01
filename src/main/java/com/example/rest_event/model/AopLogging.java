package com.example.rest_event.model;

import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;

//@Aspect
//@Configuration
public class AopLogging {

  //  @Pointcut("execution(* com.example.rest_event.model.*.*(..))")
    private void selectAllMethods() {
    }

    //@Before("selectAllMethods()")
    public void beforeAdvice(){
        System.out.println("Going to setup student profile.");
    }

    /**
     * This is the method which I would like to execute
     * after a selected method execution.
     */
    //@After("selectAllMethods()")
    public void afterAdvice(){
        System.out.println("Student profile has been setup.");
    }

    /**
     * This is the method which I would like to execute
     * when any method returns.
     */
    //@AfterReturning(pointcut = "selectAllMethods()", returning = "retVal")
    public void afterReturningAdvice(Object retVal){
        System.out.println("Returning:" + retVal.toString() );
    }

    /**
     * This is the method which I would like to execute
     * if there is an exception raised by any method.
     */
   // @AfterThrowing(pointcut = "selectAllMethods()", throwing = "ex")
    public void AfterThrowingAdvice(IllegalArgumentException ex){
        System.out.println("There has been an exception: " + ex.toString());
    }
}