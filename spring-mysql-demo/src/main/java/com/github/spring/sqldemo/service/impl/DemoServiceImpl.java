package com.github.spring.sqldemo.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.spring.sqldemo.mapper.DemoMapper;
import com.github.spring.sqldemo.mapper.DriverinfoMapper;
import com.github.spring.sqldemo.model.Demo;
import com.github.spring.sqldemo.model.Driverinfo;
import com.github.spring.sqldemo.model.Sqldemo;
import com.github.spring.sqldemo.model.Tasklist;
import com.github.spring.sqldemo.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class DemoServiceImpl implements DemoService {

    @Lazy
    @Autowired(required = false)
    private DemoMapper demoMapper;

    @Autowired
    private DriverinfoMapper driverinfoMapper;

    @Override
    public String get(String name) {

        QueryWrapper<Demo> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("name",name);
        demoMapper.selectList(queryWrapper);
        return "ok";
    }

    @Override
    public String dataSave(JSONObject json) {
        log.info(json.toJSONString());

        Class classzz=this.getClass();

        try{
            Class clazz=Class.forName("Demo",true,this.getClass().getClassLoader());
            Object demo=JSONObject.parseObject(json.toJSONString(),clazz);

//            this.getDemoValue(demo);

            Demo demo2=JSON.parseObject(json.toString(),Demo.class);

        }catch (ClassNotFoundException ex){
            ex.printStackTrace();
        }

        return "ok";
    }

    public void getDemoValue(Demo demo){
        log.info("demo.contractcode:="+demo.getContractcode());
    }

    @Override
    public void delete(Demo demo) {
        log.info(demo.getContractcode());
        return;
    }

    /**
     * 连接一
     * @param value
     * @return
     */
    @Override
    public String getOne(String value) {
        Driverinfo driverinfo2=new Driverinfo();
        List<Driverinfo> list=driverinfoMapper.selectByPage(driverinfo2);

//        List<Driverinfo> list=demoMapper.getOne();
        for(Driverinfo info:list){
            log.info(">>Drivername="+info.getDrivername());
        }
        return null;
    }

    /**
     * 连接二
     * @param value
     * @return
     */
    @Override
    @DS("test")
    public String getTwo(String value) {
        List<Tasklist> list=demoMapper.getTwo();
        for(Tasklist info:list){
            log.info(">>Drivername="+info.getCommname());
        }
        return null;
    }

    @Override
    public List<Sqldemo> getSqlDemo(String value) {
        return demoMapper.getSQLDemo();
    }


}
