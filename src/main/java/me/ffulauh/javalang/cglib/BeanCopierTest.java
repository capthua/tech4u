package me.ffulauh.javalang.cglib;


import net.sf.cglib.beans.BeanCopier;

public class BeanCopierTest {

    public static void main(String[] args) {
        BeanCopier copier=BeanCopier.create(SampleBean.class,OtherSampleBean.class,false);
        SampleBean sampleBean=new SampleBean();
        sampleBean.setValue("hello cglib");
        OtherSampleBean otherSampleBean=new OtherSampleBean();
        copier.copy(sampleBean,otherSampleBean,null);
        System.out.println(otherSampleBean.getValue());
    }
}
