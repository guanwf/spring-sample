package com.github.spring.sqldemo.model;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Data
//@Document(collection = "demo")
public class Demo {

    /**
     * 系统合同号
     */
    @NotEmpty(message = "系统合同号不能为空")
    @Length(max = 20, message = "系统合同号长度不能大于20")
    private String contractid;

    /**
     * 物理合同号
     */
    @NotEmpty(message = "物理合同号不能为空")
    @Length(max = 20, message = "物理合同号长度不能大于20")
    private String contractcode;

}
