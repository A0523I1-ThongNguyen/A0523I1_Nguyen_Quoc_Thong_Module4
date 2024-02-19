package com.example.ss9_app_muon_sach.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BookAOP {
    @Before(" execution(* com.example.ss9_app_muon_sach.controller.BookController.*(..))")
    public void callAfterShowList2(JoinPoint joinPoint) {
        System.out.println("Before run Programming. Name Method is : " + joinPoint.getSignature().getName());
    }

    @After(" execution(* com.example.ss9_app_muon_sach.controller.BookController.*(..))")
    public void callAfterShowList(JoinPoint joinPoint) {
        System.out.println("After run Programming.  Name Method is  : " + joinPoint.getSignature().getName());
    }

    private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());
    private int count;

    @After("execution(* com.example.ss9_app_muon_sach.controller.BookController.*(..))")
    public void showMethod(JoinPoint joinPoint) {
        System.out.println("------------------------------------------------------------------");
        String methodName = joinPoint.getSignature().getName();
        logger.info("Tên phương thức: " + methodName);
        count++;
        System.out.println("Số lần truy cập (Resert Trang Web): " + count);
        System.out.println("------------------------------------------------------------------");
    }
}
