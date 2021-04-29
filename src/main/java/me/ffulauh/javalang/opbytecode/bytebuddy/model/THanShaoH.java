package me.ffulauh.javalang.opbytecode.bytebuddy.model;

import javax.persistence.Id;
import javax.persistence.Table;

public class THanShaoH {

    @Id
    private Integer id;

    private String myName;
    private Double myMoney;

    public String getMyName() {
        return myName;
    }

    public void setMyName(String myName) {
        this.myName = myName;
    }

    public Double getMyMoney() {
        return myMoney;
    }

    public void setMyMoney(Double myMoney) {
        this.myMoney = myMoney;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
