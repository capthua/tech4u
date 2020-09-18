package me.ffulauh.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
        // 可能有一个负号 -?
        // 数字 \d
        // 一个或多个之前的表达式 +
        // 可能有一个负号，后面跟一位或多位数字 -?\\d+
//        System.out.println("-1234".matches("-?\\d+")); //true
//        System.out.println("5".matches("-?\\d+")); //true
//        System.out.println("+911".matches("-?\\d+")); //false

        // 可能有一个+或-开头，或二者皆没有 (-|\\+)?
//        System.out.println("+911".matches("(-|\\+)?\\d+")); //true

        // 非单词字符 \W  单词字符 \w

        String ff="aaBcdefabcdefabcabc";
        Pattern p=Pattern.compile("a(abc(def(abc)))",Pattern.CASE_INSENSITIVE);
        Matcher matcher = p.matcher(ff);
        while (matcher.find()){
            for(int j=0;j<=matcher.groupCount();j++){
                System.out.println(matcher.group(j)+","+matcher.start(j)+","+(matcher.end(j)-1));
            }
        }

//        String ff="Java now has regular expressions";
//        String regex="^Java"; //0,3
//        String regex="^Java"; //0,3
//        String ff="Evening is full of the linnet's wings";
//        String regex="\\w+";
//        for(int i=0;i<100;i++){
//            Pattern p=Pattern.compile(regex);
//            Matcher matcher = p.matcher(ff);
//            int j=0;
//            while (matcher.find(j)){
//                System.out.println(matcher.group()+","+matcher.start()+","+(matcher.end()-1));
//                j++;
//            }
//        }


    }
}
