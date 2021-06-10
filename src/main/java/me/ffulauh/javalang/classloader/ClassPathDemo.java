package me.ffulauh.javalang.classloader;

import java.net.URLClassLoader;

public class ClassPathDemo {

    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader classLoader=Thread.currentThread().getContextClassLoader();
        Class<Han> clazz = (Class<Han>) Class.forName("me.ffulauh.javalang.classloader.Han",false
                ,Thread.currentThread().getContextClassLoader());
        clazz = (Class<Han>) Class.forName("me.ffulauh.javalang.classloader.Han",true
                ,Thread.currentThread().getContextClassLoader());
        URLClassLoader urlClassLoader=(URLClassLoader) classLoader;
        Han han=new Han();
        System.out.println("hehe");
    }
}
