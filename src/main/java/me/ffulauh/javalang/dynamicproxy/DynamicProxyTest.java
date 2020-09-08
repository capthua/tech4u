package me.ffulauh.javalang.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxyTest {

    interface IHello {
        void sayHello();
    }

    static class Hello implements IHello {
        @Override
        public void sayHello() {
            System.out.println("Hello World");
        }
    }

    static class DynamicProxy implements InvocationHandler {

        Object originalObj;

        Object bind(Object originalObj) {
            this.originalObj = originalObj;
            return Proxy.newProxyInstance(originalObj.getClass().getClassLoader(), originalObj.getClass().getInterfaces(), this);
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if(Object.class.equals(method.getDeclaringClass())) {
                System.out.println("welcome");
                return method.invoke(this,args);
            }
            Hello hello=new Hello();
            return hello;
        }
    }

    public static void main(String[] args) {
        Hello hello=new Hello();
        DynamicProxy dp=new DynamicProxy();
        IHello helloProxy=(IHello)dp.bind(hello);
        System.out.println(dp.hashCode());
//        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
        System.out.println(helloProxy.hashCode());

    }

}
