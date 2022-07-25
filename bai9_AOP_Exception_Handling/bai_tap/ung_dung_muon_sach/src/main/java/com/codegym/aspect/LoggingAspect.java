package com.codegym.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {
    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Pointcut("execution(* com.codegym.service.impl.BookServiceImpl.*(..))")
    public void bookService(){}

    @Before("bookService()")
    public void getLog(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        logger.info("Before: Call " + methodName);
    }

    // advice chính là phương thức getLogAround(), loại advice là Around Advice
    // point cut refer method bookservice => "execution(* codegym.vn.demo.service.BookService.*(..))"
    // từ cái execution trên => join point là các phương thức trong class BookServiceImpl => có 7 join point
    // point cut là tập hợp 7 join point
    @Around("bookService()")
    public Object getLogAround(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        logger.info("Around: Begin call " + methodName);
        Object result = joinPoint.proceed(); // findAll()
        logger.info("Around: End call " + methodName);
        return result;
    }

    @After("execution(* com.codegym.service.impl.BookServiceImpl.findAll())")
    public void getLogAfter(JoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        logger.info("After: End call " + methodName);
    } //weave

    @AfterReturning("execution(* com.codegym.service.impl.BookServiceImpl.fi*(..))")
    public void getLogAfterRunning(JoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        logger.info("After returning: End call " + methodName);
    }
}
