package me.ffulauh.javalang.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.lang.reflect.Method;

public class Beans implements MethodInterceptor {

    private PropertyChangeSupport propertyChangeSupport;
    static final Class c[]=new Class[0];

    public void addPropertyChangeListener(PropertyChangeListener listener){
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        return null;
    }

    public static Object newInstance(Class clazz){
        Beans interceptor=new Beans();
        Enhancer e=new Enhancer();
        e.setSuperclass(clazz);
        e.setCallback(interceptor);
        Object bean=e.create();
        interceptor.propertyChangeSupport=new PropertyChangeSupport(bean);
        return bean;
    }
}
