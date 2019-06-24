package com.github.spring.demo.model;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Lazy(true)
@Service
public class Person {

    private int i = 0;

    public Person() {
        System.out.println("实例化一个对象");
    }

    public void add() {
        System.out.println("i=" + i++);
    }

}
