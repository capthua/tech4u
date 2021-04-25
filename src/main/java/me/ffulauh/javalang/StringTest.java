package me.ffulauh.javalang;

public class StringTest {
    public static void main(String[] args) {
        //StringBuilder sb=new StringBuilder();
        StringBuffer sb=new StringBuffer();
        sb.append("01234");
        sb.append("abcd",2,3);
        System.out.println(sb);
    }
}
