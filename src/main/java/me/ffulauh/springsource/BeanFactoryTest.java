package me.ffulauh.springsource;


import me.ffulauh.domain.A;
import me.ffulauh.domain.B;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class BeanFactoryTest {

    public static void main(String[] args) {
        BeanFactory bf=new XmlBeanFactory(new ClassPathResource("circularRefTest.xml"));
//        BeanFactory bf=new XmlBeanFactory(new ClassPathResource("beanFactoryTest.xml"));
//        ApplicationContext bf=new ClassPathXmlApplicationContext("beanFactoryTest.xml");
//        MyTestBean bean=(MyTestBean) bf.getBean("a");
//        String hehe=bean.getTestStr();

        A a=(A) bf.getBean("a");
        B b=(B) bf.getBean("b");

        System.out.println("hehe");
    }

}
