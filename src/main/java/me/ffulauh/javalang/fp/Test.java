package me.ffulauh.javalang.fp;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
//        lambda表达式
//        Work work=(Me me) -> me.getName();

        Work work= PrintUtils::print;
//        Work work=(me) -> me.getName();
        test(work);
//        将方法作为值传递， method reference
//        work=Me::getName;
//        success(work);

        List<String> list=new ArrayList<>();
    }

    static void test(Work work){
        Me me=new Me("han",28);
        work.success(me);
    }
}
