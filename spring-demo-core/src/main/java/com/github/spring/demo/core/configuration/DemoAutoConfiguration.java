package com.github.spring.demo.core.configuration;

import com.github.spring.demo.core.bootstrap.DemoBootstrap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Slf4j
@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableConfigurationProperties
@ComponentScan(basePackages = { "com.github.spring.demo.core" })
public class DemoAutoConfiguration {

    @Bean
    public DemoBootstrap demoBootstrap() {
        log.info(">>DemoBootstrap-Bean");
        final DemoBootstrap bootstrap = new DemoBootstrap();
        return bootstrap;
    }

}
