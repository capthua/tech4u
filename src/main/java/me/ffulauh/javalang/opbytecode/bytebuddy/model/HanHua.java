package me.ffulauh.javalang.opbytecode.bytebuddy.model;

import javax.persistence.Column;

public class HanHua {

    private Integer id;

    @Column(name = "t_my_name")
    private String myName;
    private Integer MyDescr;

    public String getMyName() {
        return myName;
    }

    public void setMyName(String myName) {
        this.myName = myName;
    }

    public Integer getMyDescr() {
        return MyDescr;
    }

    public void setMyDescr(Integer myDescr) {
        MyDescr = myDescr;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
