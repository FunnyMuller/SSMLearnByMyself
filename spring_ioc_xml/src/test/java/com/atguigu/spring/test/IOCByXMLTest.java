package com.atguigu.spring.test;

import com.atguigu.spring.pojo.Clazz;
import com.atguigu.spring.pojo.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOCByXMLTest {
    @Test
    public void testIOC(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc.xml");
        Student student = ioc.getBean("studentFive",Student.class);
        System.out.println(student);
    }
    @Test
    public void DI(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc.xml");
//        Clazz clazz = ioc.getBean("clazzOne", Clazz.class);
//        System.out.println(clazz);
        Student studentFive = ioc.getBean("studentFive", Student.class);
        System.out.println(studentFive);
    }
}
