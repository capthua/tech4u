package me.ffulauh.javalang.referencetest;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

public class Test {

    private static List list=new ArrayList();

    public static void main(String[] args) {
        //testStrongReference();
        testSoftReference();
    }

    private static void testStrongReference(){
        byte[] buff=new byte[1024*1024*2];
    }

    private static void testSoftReference(){
        for(int i=0;i<10;i++){
            byte[] buff=new byte[1024*1024];
            SoftReference<byte[]> sr=new SoftReference<>(buff);
            list.add(sr);
        }
        System.gc();
        for(int i=0;i<list.size();i++){
            Object obj=((SoftReference)list.get(i)).get();
            System.out.println(obj);
        }
    }

}
