package me.ffulauh.springsource.postprocessor;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class PropertyConfigurerDemo {

    public static void main(String[] args) {
//        ConfigurableListableBeanFactory bf=new XmlBeanFactory(new ClassPathResource("beanFactoryPostProcessorTest.xml"));
        ApplicationContext context=new ClassPathXmlApplicationContext("beanFactoryPostProcessorTest.xml");

        BeanFactoryPostProcessor bfpp=(BeanFactoryPostProcessor)context.getBean("bfpp");
//        bfpp.postProcessBeanFactory(bf);
        System.out.println(context.getBean("simpleBean"));
    }
}
