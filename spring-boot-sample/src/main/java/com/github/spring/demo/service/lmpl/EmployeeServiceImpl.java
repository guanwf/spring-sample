package com.github.spring.demo.service.lmpl;

import com.github.spring.demo.service.IEmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service("EmployeeService")
public class EmployeeServiceImpl implements IEmployeeService {

    @Override
    public String getEmployeeById(long id) {
        log.info("IEmployeeService");
        return null;
    }
}
