package com.github.spring.demo.service;

import com.github.spring.demo.model.Vender;
import org.springframework.stereotype.Service;

public interface IVenderService {
    String get(long id);
    int add(Vender vender);
    boolean check(long id);
}
