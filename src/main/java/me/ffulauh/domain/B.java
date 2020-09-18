package me.ffulauh.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class B {

    @Autowired
    private A a;

    private Integer age;

    public A getA() {
        return a;
    }

    public void setA(A a) {
        this.a = a;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
