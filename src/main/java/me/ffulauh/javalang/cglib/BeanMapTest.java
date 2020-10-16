package me.ffulauh.javalang.cglib;

import net.sf.cglib.beans.BeanGenerator;

public class BeanMapTest {
    public static void main(String[] args) {
        BeanGenerator generator=new BeanGenerator();
        generator.addProperty("username",String.class);
        generator.addProperty("password",String.class);
        Object bean=generator.create();
    }
}
