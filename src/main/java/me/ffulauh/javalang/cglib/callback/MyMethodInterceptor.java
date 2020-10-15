package me.ffulauh.javalang.cglib.callback;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class MyMethodInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("before method run...");
        Object result=proxy.invokeSuper(obj,args);
        System.out.println("after method run...");
        return result;
    }
}
