package com.github.spring.demo.config;

import com.github.spring.demo.model.Person;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;

@Configuration
@EnableAutoConfiguration
public class AutoConfig {

//    @Lazy
//    public Person person(){
//        return new Person();
//    }
}
