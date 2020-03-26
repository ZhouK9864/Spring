package com.Myclud.Utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.sql.SQLException;
@Component("txMananger")
@Aspect
public class TransactionMananger {

    @Resource
    private ConnectionUtils connectionUtils;

    @Pointcut("execution(* com.Myclud.Service.impl.*.*(..))")
    public void pt1(){
    }

//    public void beginTransaction(){
//        try {
//            connectionUtils.getThreadConnection().setAutoCommit(false);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//    public void commit(){
//        try {
//            connectionUtils.getThreadConnection().commit();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//    public void rollback(){
//        try {
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//    public void release(){
//        try {
//            connectionUtils.getThreadConnection().close();
//            connectionUtils.connectionRemove();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    @Around("pt1()")
    public Object aroundImport(ProceedingJoinPoint proceedingJoinPoint) throws Exception {
        Object rtValue = null;
        try{
            Object[] args = proceedingJoinPoint.getArgs();
            connectionUtils.getThreadConnection().setAutoCommit(false);
            rtValue = proceedingJoinPoint.proceed(args);
            connectionUtils.getThreadConnection().commit();
            return rtValue;
        } catch (Throwable throwable) {
            connectionUtils.getThreadConnection().rollback();
            throw new RuntimeException(throwable);
        }finally {
            connectionUtils.getThreadConnection().close();
            connectionUtils.connectionRemove();
        }

    }



}

