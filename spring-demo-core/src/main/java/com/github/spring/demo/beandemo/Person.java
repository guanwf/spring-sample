package com.github.spring.demo.beandemo;

import lombok.Data;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

@Data
public class Person implements BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean {

    private String name;
    private String address;
    private int phone;
    private BeanFactory beanFactory;
    private String beanName;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("【BeanFactoryAware接口】调用BeanFactoryAware.setBeanFactory()");
        this.beanFactory = beanFactory;
    }

    @Override
    public void setBeanName(String beanName) {
        System.out.println("【BeanNameAware接口】调用BeanNameAware.setBeanName()");
        this.beanName = beanName;
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("【DiposibleBean接口】调用DiposibleBean.destory()");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("【InitializingBean接口】调用InitializingBean.afterPropertiesSet()");
    }

}
