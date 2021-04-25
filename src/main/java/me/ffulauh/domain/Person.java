package me.ffulauh.domain;

public class Person {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    //@Override
    //public int hashCode() {
    //    return name != null ? name.hashCode() : 0;
    //}
}
