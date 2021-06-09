package me.ffulauh.javalang.stream;

import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.List;

public class SteamTest {
    public static void main(String[] args) {
        List<Integer> list= Lists.newArrayList(2,10,8,6);
        Integer hehe=list.stream().filter(x->x>10).findAny().orElse(23);
        System.out.println(hehe);
    }
}
