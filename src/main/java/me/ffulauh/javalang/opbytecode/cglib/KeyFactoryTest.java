package me.ffulauh.javalang.opbytecode.cglib;

import net.sf.cglib.core.KeyFactory;

public class KeyFactoryTest {

    public static void main(String[] args) {
        SampleKeyFactory keyFactory= (SampleKeyFactory)KeyFactory.create(SampleKeyFactory.class);
        Object o1=keyFactory.newInstance("foo",42);
        Object o2=keyFactory.newInstance("foo",42);
        System.out.println(o1.equals(o2));
        System.out.println(o1.hashCode()==o2.hashCode());
    }

}
