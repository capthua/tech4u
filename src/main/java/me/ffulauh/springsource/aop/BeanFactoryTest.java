package me.ffulauh.springsource.aop;

import me.ffulauh.domain.MyTestBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanFactoryTest {

    public static void main(String[] args) {
//        BeanFactory bf=new XmlBeanFactory(new ClassPathResource("beanFactoryTest.xml"));
        ApplicationContext bf=new ClassPathXmlApplicationContext("beanFactoryTest.xml");
        MyTestBean bean=(MyTestBean) bf.getBean("myTestBean");
        MyTestBean bean2=(MyTestBean) bf.getBean("myTestBean");
        bean.test();
    }

}
