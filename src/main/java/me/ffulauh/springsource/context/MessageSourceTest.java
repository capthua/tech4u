package me.ffulauh.springsource.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.GregorianCalendar;
import java.util.Locale;

public class MessageSourceTest {

    public static void main(String[] args) {
        String[] configs={"messageTest.xml"};
        ApplicationContext ctx=new ClassPathXmlApplicationContext(configs);
        Object[] params={"John",new GregorianCalendar().getTime()};
        String msg1=ctx.getMessage("test",params, Locale.US);
        System.out.println(msg1);

    }

}
