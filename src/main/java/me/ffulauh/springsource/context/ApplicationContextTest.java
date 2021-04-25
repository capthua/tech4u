package me.ffulauh.springsource.context;

import me.ffulauh.domain.E;
import me.ffulauh.domain.F;
import me.ffulauh.domain.MyTestBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@ComponentScan
public class ApplicationContextTest {


    public static void main(String[] args) {
//                ApplicationContext context=new MyClassPathXmlApplicationContext("beanFactoryTest.xml");
//        ApplicationContext context=new ClassPathXmlApplicationContext("beanFactoryTest.xml");

        ApplicationContext context=new ClassPathXmlApplicationContext("autowire.xml");

        MyTestBean bean=(MyTestBean) context.getBean("myTestBean");


//        E e=(E) context.getBean("e");
//        F f=(F) context.getBean("f");

        System.out.println("hehe");
        ((AbstractXmlApplicationContext)context).close();

    }
}
