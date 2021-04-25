package me.ffulauh.domain;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;

@Component
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class MyTestBean implements BeanFactoryAware, DisposableBean , InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("调用InitializingBean接口的afterPropertiesSet");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("调用DisposableBean接口的destroy()");
    }

    public void customInit() throws Exception {
        System.out.println("调用自定义init");
    }

    public void customDestroy() throws Exception {
        System.out.println("调用自定义destroy()");
    }

    //    private BeanFactory beanFactory;

    private Person person;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
//        this.beanFactory=beanFactory;
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("postConstruct");
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("preDestroy");
    }

    public MyTestBean(){
        System.out.println("myTestBean实例化");
    }

    private String testStr;

    public String getTestStr() {
        return testStr;
    }

    public void setTestStr(String testStr) {
        this.testStr = testStr;
    }

    public void test(){
        System.out.println("test");
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
