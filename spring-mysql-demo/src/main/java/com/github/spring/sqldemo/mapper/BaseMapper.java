package com.github.spring.sqldemo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface BaseMapper<T> {

    @Select("${value}")
    void execsql(String sql);

    @Select("${value}")
    String getValue(String sql);

    @Select("${value}")
    HashMap getMap(String sql);

    @Select("${value}")
    List<HashMap> getlist(String sql);

    @SelectProvider(type = DynamicSql.class, method = "getSql")
    List<HashMap> DynamicSql(Map<String, Object> param);

    @SelectProvider(type = DynamicSql.class, method = "getSql")
    String DynamicSqlByStr(Map<String, Object> param);

    @SelectProvider(type = DynamicSql.class, method = "getSql")
    List<T> DynamicTSql(Map<String, Object> param);


}