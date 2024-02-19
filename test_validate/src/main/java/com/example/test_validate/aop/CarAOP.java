package com.example.test_validate.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CarAOP {
    @After("execution(* com.example.test_validate.controller.CarController.*(..))")
    public void testAOP(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName());
    }

//    @After(" execution(* com.example.demo_aop.controller.StudentController.showList(..))")
//    public void callBeforeShowList(JoinPoint joinPoint){
//        System.out.println(joinPoint.getSignature().getName());
//    }
}
