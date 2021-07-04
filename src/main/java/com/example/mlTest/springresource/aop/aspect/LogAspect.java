package com.example.mlTest.springresource.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author miaoliang
 * @since 6/30/21 5:03 PM
 */
@Aspect  // 这个类被声明是被动态织入到 虚拟切面中的类
@Component // 声明这个类是被SpringIOC容器管理的
public class LogAspect {

    private final static Logger log = LoggerFactory.getLogger(LogAspect.class);

//    @Pointcut("execution(* com.example.mlTest.springresource.aop.service.*.*(..))")  //声明切点--利用反射读取切面中所有的注解信息
    // pubic（可省略），返回值类型，包路径，类，方法名，（参数），throws异常类型（可省略）
    @Pointcut("execution(* com.example.mlTest.springresource.aop.service..*(..))")  //声明切点--利用反射读取切面中所有的注解信息(..目录所有的层级)
    public void LogAspect(){}

    @Before("LogAspect()")
    public void before(JoinPoint joinPoint){
        log.error("调用方法之前" + joinPoint);
    }

    @After("LogAspect()")
    public void afterReturn(JoinPoint joinPoint){
        log.error("调用方法之后" + joinPoint);
    }
    @AfterThrowing("LogAspect()")
    public void afterThrow(JoinPoint joinPoint){
        log.error("方法 异常之后" + joinPoint);
    }

    @AfterReturning("LogAspect()")
    public void doAfterReturning(JoinPoint joinPoint){
        log.error("doAfterReturning");
    }

    @AfterThrowing("LogAspect()")
    public void deAfterThrowing(JoinPoint joinPoint){
        log.error("deAfterThrowing");
    }

    @Around("LogAspect()")
    public Object deAround(ProceedingJoinPoint joinPoint) throws Throwable{
        log.error("deAround");
        return joinPoint.proceed();
    }

}
