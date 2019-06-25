package com.github.spring.demo;

import com.github.spring.demo.config.BeanDemo;
import com.github.spring.demo.core.utils.SpringBeanUtils;
import com.github.spring.demo.model.Person;
import com.github.spring.demo.service.IEmployeeService;
import com.github.spring.demo.service.IVenderService;
import com.github.spring.demo.service.lmpl.EmployeeService2Impl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes=SpringSapmleApplication.class)
public class SpringSapmleApplicationTests {

	@Test
	public void contextLoads() {

	}

	@Test
	public void Test1(){
		BeanDemo beanDemo= SpringBeanUtils.getInstance().getBean(BeanDemo.class);
		log.info(beanDemo.getValue());
	}

	@Autowired
	@Qualifier("EmployeeService2")
	IEmployeeService employeeService;
//	IEmployeeService employeeService=new EmployeeService2Impl();

	@Test
	public void Test2(){
		employeeService.getEmployeeById(1L);
	}

	@Autowired
    IVenderService venderService;

	@Test
	public void Test3(){
		venderService.get(1L);
	}

//	@Autowired
//	Person person;

	@Test
	public void Test4(){
//		ApplicationContext ac = new ClassPathXmlApplicationContext();
//		Person beanDemo=(Person)ac.getBean("person");

//		person.add();
	}

}
