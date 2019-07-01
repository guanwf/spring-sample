package com.github.spring.demo.beandemo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(Object arg0, String arg1) throws BeansException {
        System.out.println("BeanPostProcessor接口方法postProcessAfterInitialization对属性进行更改！");
        return arg0;
    }

    @Override
    public Object postProcessBeforeInitialization(Object arg0, String arg1)throws BeansException {
        System.out.println("BeanPostProcessor接口方法postProcessBeforeInitialization对属性进行更改！");
        return arg0;
    }

}
