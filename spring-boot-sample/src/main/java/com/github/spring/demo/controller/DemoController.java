package com.github.spring.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DemoController {

    @RequestMapping(value = "/")
    public String index(){
        return "index";
    }

    @RequestMapping("/demo")
    public ModelAndView onDemo(){
        //https://www.cnblogs.com/nicknailo/p/8947643.html

        //https://blog.csdn.net/hz_940611/article/details/80732285

        //spring-boot-starter-thymeleaf的作用
        //https://blog.csdn.net/starcraft501/article/details/82826185

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("demo");
        return modelAndView;
    }

}
