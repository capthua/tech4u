package me.ffulauh.javalang.cglib;

import net.sf.cglib.beans.ImmutableBean;

public class SampleBean {
    private String value;

    public SampleBean() {
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


}