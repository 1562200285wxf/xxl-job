package com.xxl.job.executor.study.spring;

import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import java.text.Annotation;

/**
 * @author ：wang xiaofeng
 * @date ：Created in 2022-11-23 16:10
 * @description：
 */
@Scope
public class SpringTest {
    /*
    * 扫描
    * parse
    * bedifination
    * */

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        genericBeanDefinition.setBeanClass(ToDo.class);

        genericBeanDefinition.setScope("singleton");
        ac.registerBeanDefinition("genericBeanDefinition",genericBeanDefinition);
        ac.refresh();
        ToDo toDo = (ToDo)ac.getBean("ToDo");
        toDo.test();
    }
}
