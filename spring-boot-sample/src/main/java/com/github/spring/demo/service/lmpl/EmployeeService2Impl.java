package com.github.spring.demo.service.lmpl;

import com.github.spring.demo.service.IEmployeeService;
import com.github.spring.demo.service.IVenderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service("EmployeeService2")
public class EmployeeService2Impl implements IEmployeeService {

    private IVenderService venderService;

    public EmployeeService2Impl(IVenderService venderService){
        this.venderService=venderService;
    }

    @Override
    public String getEmployeeById(long id) {
        log.info("IEmployeeService2");
        return null;
    }
}
