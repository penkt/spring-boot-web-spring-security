/*
package com.pengkey.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

@Aspect
public class FieldConvertHandler {
    private static final Logger logger = LoggerFactory.getLogger(FieldConvertHandler.class);

    @Pointcut("execution(* com.pengkey.web..*.*(..))")
    public void doPointCut(){

    }

    @Before("doPointCut()")
    public void doBefore(ProceedingJoinPoint proceedingJoinPoint){
        logger.info("----------------------------------FieldConvertHandler start--------------------------");
        Signature signature=proceedingJoinPoint.getSignature();
        MethodSignature methodSignature=(MethodSignature)signature;
        Class<?>[] parameterTypes=methodSignature.getParameterTypes();
        for (Class c:parameterTypes){
            Field[] fields=c.getDeclaredFields();

        }
    }

}
*/
