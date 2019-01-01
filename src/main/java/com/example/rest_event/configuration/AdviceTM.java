package com.example.rest_event.configuration;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;


/*
   <tx:advice id = "txAdvice" transaction-manager = "transactionManager">
      <tx:attributes>
      <tx:method name = "create"/>
      </tx:attributes>
   </tx:advice>

   <aop:config>
      <aop:pointcut id = "createOperation"
         expression = "execution(* com.tutorialspoint.StudentJDBCTemplate.create(..))"/>

      <aop:advisor advice-ref = "txAdvice" pointcut-ref = "createOperation"/>
   </aop:config>
 */
@Aspect
public class AdviceTM {

    @Pointcut("execution(* com.example.rest_event.event.AddToDatabaseListener.onApplicationEvent(..))")
    public void performOperation(){}


}
