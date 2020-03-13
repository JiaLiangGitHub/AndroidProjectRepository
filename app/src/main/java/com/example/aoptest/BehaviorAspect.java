package com.example.aoptest;

import android.os.SystemClock;
import android.util.Log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.annotation.Annotation;

@Aspect
public class BehaviorAspect {
    //用正则表达的方法 表明带有BehaviorTrace注解的方法都属于这个切面
    // * *(..)表示任意类的任意方法
    //@com.example.aoptest.BehaviorTrace :被打上了BehaviorTrace注解
    @Pointcut("execution(@com.example.aoptest.BehaviorTrace  * *(..))")// 定义切点
    public void methodWithBehaviorTraceAnnotation() {
    }
    @Around("methodWithBehaviorTraceAnnotation()")
    public void weaveJoinPoint(ProceedingJoinPoint point) throws Throwable {
        //方法执行前
        MethodSignature signature = (MethodSignature) point.getSignature();
        String className = signature.getDeclaringType().getSimpleName(); //获取类名
        String methodName = signature.getName();  //获取方法名
        //获取注解
        BehaviorTrace behaviorTrace = signature.getMethod().getAnnotation(BehaviorTrace.class);
        long beginTime = System.currentTimeMillis();
        point.proceed();
        long duration = System.currentTimeMillis() - beginTime;
        Log.d("Jia", "weaveJoinPoint: " + className + "类中的方法:" + methodName + "; 功能:" + behaviorTrace.value() + "; 执行时间" + duration + "毫秒");

    }
}
