package com.github.spring.sqldemo.exposer;

import com.alibaba.fastjson.JSONObject;
import com.github.spring.sqldemo.model.Demo;
import com.github.spring.sqldemo.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;


@Slf4j
@Component("abc.demo")
public class DemoExposer {

    @Autowired
    DemoService demoService;

    public String get(@RequestParam(name = "name") String name) {
        return demoService.get(name);
    }

    public String dataSave(JSONObject json){
        return demoService.dataSave(json);
    }

    public void delete(Demo demo){
        demoService.delete(demo);
    }
}
