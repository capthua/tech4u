package me.ffulauh.javalang.concurrent.collectiontest;

import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListTest {

    private static CopyOnWriteArrayList<String> list=new CopyOnWriteArrayList<>();

    public static void main(String[] args) {
        for(int i=0;i<3;i++){
            new Thread(()->{
                list.add(Thread.currentThread().getName());
                list.add("hehe");
                list.get(2);
            }).start();
        }
        System.out.println("hehe");
    }

}
