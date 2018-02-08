package com.pengkey.aop;

import com.pengkey.compent.GeneralIdWorks;
import com.pengkey.constant.CommonConstant;
import com.pengkey.expection.GenerBizException;
import com.pengkey.response.BaseResponse;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Aspect
@Component
public class GeneralHandler {
    private static final Logger logger = LoggerFactory.getLogger(GeneralHandler.class);

    @Autowired
    private GeneralIdWorks generalIdWorks;
    @Autowired
    HttpServletRequest request;

    @Pointcut("execution(* com.pengkey.web.restController..*(..))")
    public void controllerPointcut(){

    }

    @Before("controllerPointcut()")
    public void preProcess(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=attributes.getRequest();
        logger.info("----------------------------------preProcess start--------------------------");
        HttpSession session=request.getSession();
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        request.setAttribute("userId",userDetails.getUsername());
        request.setAttribute("requestNo",generalIdWorks.nextId());
        request.setAttribute("startTime",new Date().getTime());
        if(request.getAttribute("channel")==null){
            request.setAttribute("channel","01");
        }
        logger.info("----------------------------------preProcess finished--------------------------");
    }
    @Around("controllerPointcut()")
    public BaseResponse doAround(ProceedingJoinPoint proceedingJoinPoint){
        BaseResponse result;
        logger.info("----------------------------------doProcess start--------------------------");
        try {
            result =(BaseResponse)proceedingJoinPoint.proceed();
            result.setMessage(CommonConstant.OPERATION_SUCCESS);
            result.setCode(CommonConstant.SUCCESS);
            result.setUserId(request.getAttribute("userId").toString());
            result.setResponseNo(request.getAttribute("requestNo").toString());
            result.setEndTime(new Date());
        } catch (Throwable throwable) {
            result= (BaseResponse)processException(proceedingJoinPoint, throwable);
        }
        logger.info("----------------------------------doProcess finished--------------------------");
        return  result;
    }

    private BaseResponse processException(ProceedingJoinPoint proceedingJoinPoint,Throwable throwable){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=attributes.getRequest();
        BaseResponse result=new BaseResponse();
        if(throwable instanceof GenerBizException){
            GenerBizException generBizException=(GenerBizException)throwable;
            result.setCode(generBizException.getCode());
            result.setMessage(generBizException.getMessage());
            result.setResponseNo(request.getAttribute("requestNo").toString());
        }else{
            logger.error("other exception");
            result.setCode(CommonConstant.FAILED);
            result.setMessage(CommonConstant.OPERATION_FAILED);
            throwable.printStackTrace();
        }
        return result;

    }

}
