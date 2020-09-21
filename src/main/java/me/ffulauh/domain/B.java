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
    private C c;

    public C getC() {
        return c;
    }

    public void setC(C c) {
        this.c = c;
    }
}
