package com.example.aoptest;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//定义注解
@Target(ElementType.METHOD) // 修饰的是方法
@Retention(RetentionPolicy.RUNTIME)  // 编译时注解
public @interface BehaviorTrace {
    String value(); //功能点名称
    int type(); // 唯一确定功能点的值

}
