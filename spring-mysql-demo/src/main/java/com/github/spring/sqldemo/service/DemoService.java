package com.github.spring.sqldemo.service;

import com.alibaba.fastjson.JSONObject;
import com.github.spring.sqldemo.SQLDemoApplication;
import com.github.spring.sqldemo.model.Demo;
import com.github.spring.sqldemo.model.Sqldemo;

import java.util.List;

public interface DemoService {

        String get(String name);

        String dataSave(JSONObject json);

        void delete(Demo demo);

        String getOne(String value);

        String getTwo(String value);

        List<Sqldemo> getSqlDemo(String value);
}
