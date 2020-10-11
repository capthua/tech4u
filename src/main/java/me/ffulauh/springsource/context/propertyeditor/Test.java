package me.ffulauh.springsource.context.propertyeditor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args) {
        ApplicationContext ctx=new ClassPathXmlApplicationContext("propertyEditorTest.xml");
        UserManager userManager= (UserManager) ctx.getBean("userManager");
        System.out.println(userManager);
    }
}
