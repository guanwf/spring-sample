package com.github.spring.sqldemo.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.wuwenze.poi.annotation.Excel;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@TableName("driverinfo")
@Excel("driverinfo单表")
public class Driverinfo {
    private String driverno;
    private String drivername;

    private int begin;
    private int size;
}