package me.ffulauh.javalang.fp;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        //匿名内部类
        Work work;
//        work=new Work() {
//            @Override
//            public void success(Me me) {
//                System.out.println(me.getName());
//            }
//        };
//
//        lambda表达式
        work=(Me me) -> System.out.println(me.getName());


        work=(me) -> me.getName();
        //        将方法作为值传递， method reference
        work=Me::getName;

        work= (me)->PrintUtils.print(me);
        work= PrintUtils::print;
        test(work);


        List<String> list=new ArrayList<>();
    }

    static void test(Work work){
        Me me=new Me("han",28);
        work.success(me);
    }
}
