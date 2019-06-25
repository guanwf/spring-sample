package com.github.spring.sqldemo.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration
@EnableTransactionManagement
@MapperScan(basePackages = "com.github.spring.sqldemo.mapper", sqlSessionFactoryRef = "sqlSessionFactory")
public class MapperConfig{

}