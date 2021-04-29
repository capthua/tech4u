package me.ffulauh.javalang.opbytecode.bytebuddy.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "t_han_shao_hua")
public class THanShaoHua {

    @Id
    private Integer id;

    @Column(name = "myName")
    private String myName;
    @Column(name = "myMoney")
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
