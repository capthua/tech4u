package me.ffulauh.javalang.opbytecode.cglib;

import net.sf.cglib.beans.BeanMap;

public class BeanMapTest {
    public static void main(String[] args) {
        Person person=new Person();
        person.setAge(18);
        person.setName("hsh");
        BeanMap map=BeanMap.create(person);
        System.out.println(map.get("age"));
        System.out.println(map.get("name"));
    }
}
