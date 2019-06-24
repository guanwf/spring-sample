package com.github.spring.demo.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Vender implements Serializable {
    private long venderid;
    private String vendername;
}
