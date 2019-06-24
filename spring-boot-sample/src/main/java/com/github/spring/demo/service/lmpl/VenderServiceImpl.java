package com.github.spring.demo.service.lmpl;

import com.github.spring.demo.model.Vender;
import com.github.spring.demo.service.IEmployeeService;
import com.github.spring.demo.service.IVenderService;
import org.springframework.stereotype.Service;

@Service
public class VenderServiceImpl implements IVenderService {

    @Override
    public String get(long id) {
        return null;
    }

    @Override
    public int add(Vender vender) {
        return 0;
    }

    @Override
    public boolean check(long id) {
        return false;
    }
}
