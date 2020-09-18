package me.ffulauh.springsource.context;


import me.ffulauh.domain.A;
import me.ffulauh.domain.B;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

@ComponentScan
public class BeanFactoryTest {


    public static void main(String[] args) {
//        BeanFactory bf=new XmlBeanFactory(new ClassPathResource("circularRefTest.xml"));
//        BeanFactory bf=new XmlBeanFactory(new ClassPathResource("autowire.xml"));
        ApplicationContext bf=new MyClassPathXmlApplicationContext("autowire.xml");
//        ApplicationContext bf=new ClassPathXmlApplicationContext("circularRefTest.xml");

//        MyTestBean bean=(MyTestBean) bf.getBean("myTestBean");
//        String hehe=bean.getTestStr();

        A a=(A) bf.getBean("a");
//        B b=(B) bf.getBean("b");

        System.out.println("hehe");
    }

}
