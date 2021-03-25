package me.ffulauh.javalang;

import java.lang.instrument.Instrumentation;

public class Test {
    public static void main(String[] args) {
//        System.out.println(Runtime.getRuntime().availableProcessors());
//        float a=10.0f;
//        double b=1;
        People han=new People("hanshaohau",27);
        People steve=new People("stevejobs",55);
        modify(han,steve);
        System.out.println("hehehe");
    }

    public static void modify(People p1,People p2){
        People temp=p2;
        p1=temp;
        p1.setName("bill");
        p2.setName("han");
    }
}
class Animal{
    public Animal(){
        System.out.println("我是动物");
    }
}
class People {

    private static Animal animal=new Animal();

    String name;
    int age;
    public People(String name,int age){
        this.name=name;
        this.age=age;
    }

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
}
