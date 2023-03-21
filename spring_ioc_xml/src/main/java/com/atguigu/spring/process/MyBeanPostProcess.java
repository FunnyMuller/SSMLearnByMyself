package com.atguigu.spring.process;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcess implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//        此方法在bean的生命周期初始化之前执行
        System.out.println("之前");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//        此方法在bean的生命周期初始化之后执行
        System.out.println("之后");
        return bean;
    }
}
