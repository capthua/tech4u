package me.ffulauh.javalang.reflection;

import me.ffulauh.javalang.reflection.model.Person;

import java.lang.reflect.Field;

public class Test {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchFieldException, ClassNotFoundException {
        Class person = Class.forName("me.ffulauh.javalang.reflection.model.Person");
        System.out.println("hehe");
    }

}
