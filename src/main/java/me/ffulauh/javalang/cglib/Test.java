package me.ffulauh.javalang.cglib;

import net.sf.cglib.proxy.Enhancer;

public class Test {
    public static void main(String[] args) {
        Enhancer enhancer=new Enhancer();
        enhancer.setSuperclass(SampleClass.class);
        enhancer.setCallback(new MyMethodInterceptor());
        SampleClass sampleClass=(SampleClass) enhancer.create();
        sampleClass.test();
        System.out.println("hehe");
    }
}
