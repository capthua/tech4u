package me.ffulauh.javalang.collectiondemo.map;


import java.util.HashMap;

public class HashMapDemo {
    public static void main(String[] args) {
        People p1=new People();
        p1.setName("han");
        p1.setAge(21);
        People p2=new People();
        p2.setName("han");
        p2.setAge(21);
        HashMap<People,String> map=new HashMap<>();
        map.put(p1,"han");
        map.put(p2,"ht");
        map.get(p2);
        People p;
        if((p=p1)!=null){

        }
        System.out.println("hehe");
    }
}
