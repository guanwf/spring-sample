package com.github.spring.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class BeanDemo {

    @Bean
    public String getValue(){
        return "beanDemo";
    }

}
