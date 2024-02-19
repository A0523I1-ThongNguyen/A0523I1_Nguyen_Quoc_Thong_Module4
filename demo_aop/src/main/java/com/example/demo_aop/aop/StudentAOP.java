package com.example.demo_aop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class StudentAOP {

//     quản lý tất cả các method
//     @After(" execution(* com.example.springboot.controller.StudentController.*(..))")
//
//     quản lý 1 method duy nhất
    @After(" execution(* com.example.demo_aop.controller.StudentController.showList(..))")
    public void callBeforeShowList(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature().getName());
    }

    //    @After()
//    public void callBeforeShowList(){
//        System.out.println("saddsa");
//    }


//    @Before(value = "test()")
//    public void testBefore(){
//        System.out.println("run before");
//    }
//    @Pointcut("execution( *com.example.demo_aop.controller.StudentController.*(..))")
//    public void test(){
//
//    }

}
