package me.ffulauh.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class B {


    private Integer age;

    private C c;

    public C getC() {
        return c;
    }

    public void setC(C c) {
        this.c = c;
    }
}
