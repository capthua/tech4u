package me.ffulauh.javalang.cglib.callback;

import net.sf.cglib.proxy.FixedValue;

public class MyFixedValue implements FixedValue {
    @Override
    public Object loadObject() throws Exception {
        return "Hello cglib";
    }
}
