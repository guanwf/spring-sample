package com.github.spring.sqldemo.controller;

import com.github.spring.sqldemo.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class DemoConroller {

    @Autowired
    DemoService demoService;

    @GetMapping("one")
    public String getOne(){
        return demoService.getOne("");
    }

    @GetMapping("two")
    public String getTwo(){
        return demoService.getTwo("");
    }

}
