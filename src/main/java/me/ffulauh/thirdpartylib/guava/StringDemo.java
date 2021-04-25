package me.ffulauh.thirdpartylib.guava;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;

import java.util.List;

public class StringDemo {
    public static void main(String[] args) {
        Splitter splitter=Splitter.on(",").trimResults().omitEmptyStrings();
        String s=", ,hehe,bb,,";
        List<String> result=splitter.splitToList(s);
        System.out.println(result);
        String hehe= Joiner.on(",").join(result);
        System.out.println(hehe);
    }
}
