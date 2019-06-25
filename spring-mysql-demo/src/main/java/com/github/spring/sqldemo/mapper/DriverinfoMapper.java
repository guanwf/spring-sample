package com.github.spring.sqldemo.mapper;

import com.github.spring.sqldemo.model.Driverinfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DriverinfoMapper extends BaseMapper<Driverinfo> {

    List<Driverinfo> selectByPage(Driverinfo driverinfo);

}
