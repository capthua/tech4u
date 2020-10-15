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

    public static void main(String[] args) {
        SampleBean bean = new SampleBean();
        bean.setValue("Hello world");
        SampleBean immutableBean = (SampleBean) ImmutableBean.create(bean); //创建不可变类
        bean.setValue("Hello world, again"); //可以通过底层对象来进行修改
        immutableBean.setValue("Hello cglib"); //直接修改将throw exception
    }

}
