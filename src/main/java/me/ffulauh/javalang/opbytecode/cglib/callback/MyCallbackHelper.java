package me.ffulauh.javalang.opbytecode.cglib.callback;

import net.sf.cglib.proxy.CallbackHelper;
import net.sf.cglib.proxy.NoOp;

import java.lang.reflect.Method;

public class MyCallbackHelper extends CallbackHelper {

    public MyCallbackHelper(Class superclass, Class[] interfaces) {
        super(superclass, interfaces);
    }

    @Override
    protected Object getCallback(Method method) {
        if(method.getDeclaringClass()!=Object.class&&method.getReturnType()==String.class){
            return new MyFixedValue();
        } else {
            return NoOp.INSTANCE;
        }
    }
}
