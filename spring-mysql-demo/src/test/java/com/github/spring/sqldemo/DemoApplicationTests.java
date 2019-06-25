package com.github.spring.sqldemo;

import com.github.spring.sqldemo.model.Sqldemo;
import com.github.spring.sqldemo.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes=SQLDemoApplication.class)
public class DemoApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    DemoService demoService;

    @Test
    public void Test01(){
        log.info(">>");

        List<Sqldemo> sqldemoList=demoService.getSqlDemo("abc");
        for(Sqldemo sqldemo:sqldemoList){
            log.info(sqldemo.getName());
        }

    }

}

