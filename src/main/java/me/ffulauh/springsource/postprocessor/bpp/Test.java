package me.ffulauh.springsource.postprocessor.bpp;

import me.ffulauh.domain.A;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("beanPostProcessorTest.xml");
        A a = (A)context.getBean("a");
        System.out.println("hehe");
    }
}
