package me.ffulauh.javalang.cglib;

import net.sf.cglib.beans.BulkBean;

public class BulkBeanTest {
    public static void main(String[] args) {
        BulkBean bulkBean=BulkBean.create(SampleBean.class,new String[]{"getValue"},new String[]{
                "setValue"},new Class[]{String.class});
        SampleBean bean=new SampleBean();
        bean.setValue("hello world");
        Object[] propertyValues=bulkBean.getPropertyValues(bean);
        System.out.println(propertyValues.length);
        System.out.println(propertyValues[0]);

        bulkBean.setPropertyValues(bean,new Object[]{"hello cglib"});
        System.out.println(bean.getValue());

    }
}
