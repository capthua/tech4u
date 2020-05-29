package me.ffulauh.javalang.fp;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Test {
    public static void main(String[] args) {
//        lambda表达式
        Work work=(Me me) -> me.getName();
//        Work work=(me) -> me.getName();
        success(work);
//        将方法作为值传递， method reference
        work=Me::getName;
        success(work);

        List<String> list=new ArrayList<>();
    }

    static void success(Work work){
        Me me=new Me("han",28);
        System.out.println(work.success(me));
    }
}
