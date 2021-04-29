package me.ffulauh.javalang.opbytecode.bytebuddy.model;


import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "t_han_shao")
public class HanShao {

    private Integer id;

    @Column(name = "my_name")
    private String myName;
    private Integer myAge;

    public String getMyName() {
        return myName;
    }

    public void setMyName(String myName) {
        this.myName = myName;
    }

    public Integer getMyAge() {
        return myAge;
    }

    public void setMyAge(Integer myAge) {
        this.myAge = myAge;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
