package me.ffulauh.javalang.opbytecode.cglib.callback;

import net.sf.cglib.proxy.InvocationHandler;

import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(method.getDeclaringClass()!=Object.class&&method.getReturnType()==String.class){
            return "hello cglib";
        } else {
            throw new RuntimeException("cannot handle");
        }
    }
}
