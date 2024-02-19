package com.example.test_ss7_car_springdata_vadilate.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CarDTO {
    @Before(" execution(* com.example.test_ss7_car_springdata_vadilate.controller.CarController.*(..))")
//    @After(" execution(* com.example.demo_aop.controller.StudentController.showList(..))")
    public void callBeforeShowList(JoinPoint joinPoint) {
        System.out.println("Run Before : " + joinPoint.getSignature().getName());
    }

    @After(" execution(* com.example.test_ss7_car_springdata_vadilate.controller.CarController.*(..))")
//    @After(" execution(* com.example.demo_aop.controller.StudentController.showList(..))")
    public void callBeforeShowList2(JoinPoint joinPoint) {
        System.out.println("Run After: " + joinPoint.getSignature().getName());
    }

}
