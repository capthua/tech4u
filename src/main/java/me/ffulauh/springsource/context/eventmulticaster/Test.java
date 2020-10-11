package me.ffulauh.springsource.context.eventmulticaster;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args) {
        String[] configs={"eventMulticasterTest.xml"};
        ApplicationContext ctx=new ClassPathXmlApplicationContext(configs);
        TestEvent event=new TestEvent("hello","msg");
        ctx.publishEvent(event);
        System.out.println("hehe");
    }
}
