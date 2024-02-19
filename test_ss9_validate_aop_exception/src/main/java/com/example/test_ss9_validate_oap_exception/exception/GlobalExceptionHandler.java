package com.example.test_ss9_validate_oap_exception.exception;

import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;
import org.thymeleaf.exceptions.TemplateInputException;

import java.sql.SQLException;

@ControllerAdvice
public class GlobalExceptionHandler extends Throwable {

    @ExceptionHandler(NullPointerException.class)
    public String handleNullPointerException(NullPointerException e) {
        return "/nullpoint";
    }

    @ExceptionHandler(ErrorDoXang.class)
    public String handleErrorDoXang(ErrorDoXang e) {
        return "/ErrorDoXang";
    }

    @ExceptionHandler(NoResourceFoundException.class)
    public String NoResourceFoundException(NoResourceFoundException e){
        return "/noresource";
    }


//
//    @ExceptionHandler(Exception.class)
//    public String handleException(Exception e) {
//        return "/exception";
//    }

    //    @ExceptionHandler(Exception.class)
//    public String handleException(Exception e) {
//        if (e instanceof NullPointerException) {
//            return "/nullpoint";
//        } else if (e instanceof ErrorDoXang) {
//            return "/ErrorDoXang";
//        } else {
//            // Xử lý các loại ngoại lệ khác
//            return "error";
//        }
//    }
}
