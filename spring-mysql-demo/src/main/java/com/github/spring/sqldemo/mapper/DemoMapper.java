package com.github.spring.sqldemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.spring.sqldemo.model.Demo;
import com.github.spring.sqldemo.model.Driverinfo;
import com.github.spring.sqldemo.model.Sqldemo;
import com.github.spring.sqldemo.model.Tasklist;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DemoMapper extends BaseMapper<Demo> {

    @Select({"select * from demo"})
    List<Demo> search(String id);

    @Select({"select * from driverinfo"})
    List<Driverinfo> getOne();

    @Select({"select * from tasklist"})
    List<Tasklist> getTwo();

    List<Driverinfo> selectByPage(Driverinfo driverinfo);

    @Select({"select * from sqldemo"})
    List<Sqldemo> getSQLDemo();
}
