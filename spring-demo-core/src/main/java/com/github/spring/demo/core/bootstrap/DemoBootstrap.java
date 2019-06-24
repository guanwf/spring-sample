package com.github.spring.demo.core.bootstrap;

import com.github.spring.demo.core.utils.SpringBeanUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Slf4j
public class DemoBootstrap implements ApplicationContextAware {

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        log.info("init.ApplicationContextAware.");

        SpringBeanUtils.getInstance().setCfgContext((ConfigurableApplicationContext) applicationContext);

    }

}
