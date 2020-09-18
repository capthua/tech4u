package me.ffulauh.domain;

public class MyTestBean {

    public MyTestBean(){}

    private String testStr;

    public String getTestStr() {
        return testStr;
    }

    public void setTestStr(String testStr) {
        this.testStr = testStr;
    }

    public void test(){
        System.out.println("test");
    }
}
