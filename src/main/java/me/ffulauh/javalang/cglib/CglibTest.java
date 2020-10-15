package me.ffulauh.javalang.cglib;

import me.ffulauh.javalang.cglib.callback.MyCallbackHelper;
import me.ffulauh.javalang.cglib.callback.MyInvocationHandler;
import me.ffulauh.javalang.cglib.callback.MyMethodInterceptor;
import net.sf.cglib.beans.BeanGenerator;
import net.sf.cglib.proxy.CallbackHelper;
import net.sf.cglib.proxy.Enhancer;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Method;

public class CglibTest {
    public static void main(String[] args) {
        Enhancer enhancer=new Enhancer();
        enhancer.setSuperclass(SampleClass.class);

//        enhancer.setCallback(new MyMethodInterceptor());
//        enhancer.setCallback(new MyFixedValue());
//        enhancer.setCallback(new MyInvocationHandler());

        CallbackHelper callbackHelper= new MyCallbackHelper(SampleClass.class,new Class[0]);
        enhancer.setCallbackFilter(callbackHelper);
        enhancer.setCallbacks(callbackHelper.getCallbacks());
        SampleClass sampleClass=(SampleClass) enhancer.create();
//        sampleClass.test("hello world");



        System.out.println("test "+sampleClass.test(null));
        System.out.println("test "+sampleClass.toString());
        System.out.println("test "+sampleClass.hashCode());
//        System.out.println("test "+sampleClass.getClass());

    }

    @Test
    public void testBeanGenerator()throws Exception{
        BeanGenerator beanGenerator=new BeanGenerator();
        beanGenerator.addProperty("value",String.class);
        Object myBean=beanGenerator.create();
        Method setter=myBean.getClass().getMethod("setValue",String.class);
        setter.invoke(myBean,"hello cglib");
        Method getter=myBean.getClass().getMethod("getValue");
        Assert.assertEquals("hello cglib",getter.invoke(myBean));
    }
}
